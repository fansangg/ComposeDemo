package com.example.compose.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.ui.theme.NormalFontColor
import com.example.compose.ui.theme.Purple500
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Preview(showBackground = true)
@Composable
fun BtnPreview() {
    MyTopBar(title = "haha")
}

@Composable
fun CommonBtn(content: String, click: () -> Unit) {
    Button(
        onClick = { click() }, modifier = Modifier
            .height(60.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(6.dp))
    ) {
        Text(text = content, modifier = Modifier.align(alignment = Alignment.CenterVertically))
    }
}

@Composable
fun MyTopBar(title: String, onBack: (() -> Unit) ? = null,barColor: Color = Purple500) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = barColor)
            .statusBarsPadding()
    ) {
        Row(modifier = Modifier.height(48.dp)) {
            if (onBack != null) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "backIcon",
                    modifier = Modifier
                        .size(36.dp)
                        .padding(8.dp)
                        .align(Alignment.CenterVertically)
                        .clickable(onClick = onBack),
                    tint = Color.White
                )
            }
        }
        Text(
            text = title,
            color = NormalFontColor,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.Center),
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Cursive
        )
    }
}