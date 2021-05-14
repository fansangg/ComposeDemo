package com.example.compose.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.R
import com.example.compose.ui.theme.NormalFontColor

@Composable
fun TopTitle(title:String,backClick:(() -> Unit)) {
    ConstraintLayout(
        modifier = Modifier
            .background(color = Color(0xff211536))
            .fillMaxWidth()
            .height(65.dp)
    ) {
        val (button, text) = createRefs()
        IconButton(
            onClick = backClick,
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top)
                start.linkTo(parent.start, margin = 5.dp)
                bottom.linkTo(parent.bottom)
            }) {
            Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = "")
        }

        Text(text = title, modifier = Modifier.constrainAs(text) {
            centerHorizontallyTo(parent)
            centerVerticallyTo(parent)
        }, fontSize = 15.sp, color = NormalFontColor, fontWeight = FontWeight.SemiBold)
    }
}