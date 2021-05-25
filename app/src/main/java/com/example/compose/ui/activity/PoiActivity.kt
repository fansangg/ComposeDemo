package com.example.compose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.graphics.Color
import com.example.compose.helper.DataFactory
import com.example.compose.ui.theme.MyApplicationTheme
import com.example.compose.widget.Content
import com.example.compose.widget.MyTopBar
import com.gyf.immersionbar.ktx.immersionBar

class PoiActivity:ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        immersionBar {
            statusBarColor("#211536")
            transparentNavigationBar()
        }

        setContent {
            MyApplicationTheme {
                Column {
                    MyTopBar(title = "TA们也来过",onBack = {finish()},barColor = Color(0xff211536))
                    Content(userData = DataFactory.createUserData()) {

                    }
                }
            }
        }
    }
}