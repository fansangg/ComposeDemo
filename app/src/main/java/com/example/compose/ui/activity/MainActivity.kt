package com.example.compose.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.bean.UserInfo
import com.example.compose.helper.DataFactory
import com.example.compose.ktx.startActivity
import com.example.compose.ui.theme.MyApplicationTheme
import com.example.compose.widget.CommonBtn
import com.example.compose.widget.MyTopBar

class MainActivity : AppCompatActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Column(Modifier.fillMaxSize()) {
                    MyTopBar(title = "Hi Compose")
                    Spacer(modifier = Modifier.height(20.dp))
                    val labels = listOf("hello world", "POI", "userList", "nav", "login","anim")
                    LazyVerticalGrid(cells = GridCells.Fixed(3)) {
                        items(labels.size) {
                            CommonBtn(content = labels[it]) {
                                when (it) {
                                    0 -> {
                                        startActivity<HelloWorldActivity>()
                                    }
                                    1 -> {
                                        startActivity<PoiActivity>()
                                    }
                                    2 -> {
                                        startActivity<UserListActivity>("list" to DataFactory.createUserData() as ArrayList<UserInfo>)
                                    }

                                    5 -> {
                                        startActivity<AnimActivity>()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

