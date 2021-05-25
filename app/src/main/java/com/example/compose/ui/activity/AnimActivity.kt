package com.example.compose.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.MyApplicationTheme
import com.example.compose.widget.*

class AnimActivity:AppCompatActivity() {

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MyApplicationTheme {
                Column {
                    MyTopBar(title = "animation",onBack = {finish()})
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                        ChangeColor()
                        Visibility()
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    ExpandText()
                    Spacer(modifier = Modifier.height(20.dp))
                    CrossfadeDemo()
                }
            }
        }
    }
}