package com.example.compose.widget

import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.NormalFontColor
import com.example.compose.ui.theme.Purple200
import com.example.compose.ui.theme.Teal200

@Composable
fun ChangeColor() {
    
    var isPurple by remember {
        mutableStateOf(true)
    }

    val color by animateColorAsState(
        if (isPurple) Purple200 else Teal200,
        animationSpec = tween(500),
        finishedListener = {
            isPurple = !isPurple
        }
    )

    Column(Modifier.padding(start = 20.dp, end = 20.dp)) {
        Button(onClick = { isPurple = !isPurple }) {
            Text(text = "change color")
        }
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .size(128.dp)
                .background(color = color)
        )
    }
}


@ExperimentalAnimationApi
@Composable
fun Visibility() {
    var visible by remember {
        mutableStateOf(true)
    }

    Column(Modifier.padding(start = 20.dp, end = 20.dp)) {
        Button(onClick = { visible = !visible }) {
            Text(text = if (visible) "hide" else "show")
        }

        Spacer(modifier = Modifier.height(15.dp))
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically() + expandVertically(Alignment.Bottom) + fadeIn(
                initialAlpha = .3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            Box(
                Modifier
                    .size(128.dp)
                    .background(Purple200)
            )
        }
    }
}

@Composable
fun ExpandText() {

    var expand by remember {
        mutableStateOf(false)
    }

    Column(Modifier.padding(start = 20.dp, end = 20.dp)) {
        Button(onClick = { expand = !expand }) {
            Text(text = if (expand) "close" else "expand")
        }

        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .padding(10.dp)
                .background(Teal200)
        ) {
            Text(
                text = "hello world，hello worldhello world，hello world，hello world，hello world，hello world，hello world，hello world，hello world，hello world，",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = NormalFontColor,
                maxLines = if (expand) Int.MAX_VALUE else 2
            )
        }
    }
}

@Composable
fun CrossfadeDemo() {

    var type by remember {
        mutableStateOf("text")
    }

    Column(Modifier.padding(start = 20.dp, end = 20.dp)) {
        Button(onClick = { type = if (type == "text") "icon" else "text" }) {
            Text(text = "change")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Crossfade(targetState = type, animationSpec = tween(500)) {
            if (it == "text") {
                Text(
                    text = "hello world",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            } else {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "")
            }
        }

    }
}