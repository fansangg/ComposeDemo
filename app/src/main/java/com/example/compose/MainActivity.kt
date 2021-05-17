package com.example.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.widget.BigCell
import com.example.compose.widget.Content
import com.example.compose.widget.DemoCode
import com.example.compose.widget.TopTitle

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                DemoCode()
                Spacer(modifier = Modifier.height(20.dp))
                TopTitle("TA们也在这里"){
                    Toast.makeText(this@MainActivity,  "title click", Toast.LENGTH_SHORT).show()
                }
                Content()
                BigCell{
                    Toast.makeText(this@MainActivity, "点击666", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}

