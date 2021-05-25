package com.example.compose.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.R
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@Preview
@Composable
fun LoginPreview(){
    LoginPage {
        
    }
}

@Composable
fun LoginPage(onBack:() -> Unit){
    ConstraintLayout {
        val (backIcon,logo,content) = createRefs()
        Image(painter = painterResource(id = R.drawable.ic_pavilion_bg), contentDescription = "bg")
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xcc211536)))
        IconButton(onClick = onBack,
            Modifier
                .size(50.dp)
                .constrainAs(backIcon) {
                    top.linkTo(parent.top, 40.dp)
                    start.linkTo(parent.start, 10.dp)
                }) {
            Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "back",tint = Color.White)
        }

        Column(
            Modifier
                .fillMaxWidth()
                .constrainAs(content) {
                    top.linkTo(parent.top, 100.dp)
                }) {
            Image(painter = painterResource(id = R.drawable.login_login_logo), contentDescription = "logo"
                ,
                Modifier
                    .wrapContentSize()
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(60.dp))
            Text(text = "请输入手机号",fontSize = 16.sp,color = Color.White)
            Spacer(modifier = Modifier.height(35.dp))
            Row {
                Text(text = "+86")
            }
            ProvideWindowInsets() {
                
            }
        }

    }
}