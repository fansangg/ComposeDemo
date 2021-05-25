package com.example.compose.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.MyApplicationTheme
import com.example.compose.widget.DemoCode
import com.example.compose.widget.MyTopBar

class HelloWorldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Column(Modifier.fillMaxSize()) {
                    MyTopBar(title = "hello world",onBack = {finish()})
                    Spacer(modifier = Modifier.height(20.dp))
                    DemoCode()
                }
            }
        }
    }
}