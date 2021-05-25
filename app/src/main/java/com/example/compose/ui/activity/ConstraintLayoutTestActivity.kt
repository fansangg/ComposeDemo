package com.example.compose.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

class ConstraintLayoutTestActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Blue)
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .padding(start = 30.dp, end = 30.dp)
                        .background(Color.Green)
                ) {
                    val box = createRef()
                    Box(Modifier.background(Color.White).constrainAs(box){
                        start.linkTo(parent.start,20.dp)
                        end.linkTo(parent.end,20.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.preferredValue(20.dp)
                        height = width
                    }) {
                        LocalContext.current
                    }
                }
            }
        }
    }

    companion object{
        fun start(c: Context){
            c.startActivity(Intent(c,ConstraintLayoutTestActivity::class.java))
        }
    }
}