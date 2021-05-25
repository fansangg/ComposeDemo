package com.example.compose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose.bean.UserInfo
import com.example.compose.ui.theme.MyApplicationTheme
import com.example.compose.widget.MyTopBar
import com.example.compose.widget.UserItem
import com.gyf.immersionbar.ktx.immersionBar

class UserListActivity : ComponentActivity() {

    private var mList: ArrayList<UserInfo>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mList = intent.getSerializableExtra("list") as ArrayList<UserInfo>
        immersionBar {
            statusBarColor("#211536")
            transparentNavigationBar()
        }
        setContent {
            MyApplicationTheme {
                Column {
                    MyTopBar(title = "TA们也来过", onBack = { finish() }, barColor = Color(0xff211536))
                    val state = rememberLazyListState()
                    LazyColumn(
                        modifier = Modifier
                            .background(Color(0xff3a304e))
                            .fillMaxWidth(),
                        state = state,
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                        contentPadding = PaddingValues(start = 25.dp)
                    ) {
                        item {
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(10.dp)
                            )
                        }
                        mList?.let { list ->
                            items(list.size) {
                                UserItem(
                                    icon = list[it].head,
                                    name = list[it].name,
                                    userId = list[it].id
                                )
                            }
                        }

                        item {
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(20.dp)
                            )
                        }

                    }
                }
            }
        }
    }
}