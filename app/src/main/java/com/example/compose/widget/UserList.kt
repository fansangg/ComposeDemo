package com.example.compose.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.ui.theme.NormalFontColor
import com.google.accompanist.coil.rememberCoilPainter

@Preview
@Composable
fun Preview() {
    UserItem(
        icon = "https://oss.sceneconsole.cn/avatar/156085168/C322C661-C22B-43F7-913B-2ABE8D9C42D5.jpg",
        name = "333",
        userId = "1234",
    )
}


@Composable
fun UserItem(icon: String, name: String, userId: String) {
    ConstraintLayout {
        val (head, userName, id) = createRefs()
        Image(painter = rememberCoilPainter(request = icon), contentDescription = "head",
            modifier = Modifier
                .size(45.dp)
                .constrainAs(head) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .clip(CircleShape)
        )
        Text(
            text = name, color = NormalFontColor, modifier = Modifier.constrainAs(userName) {
                top.linkTo(head.top)
                start.linkTo(head.end, 5.dp)
                bottom.linkTo(id.top)
            }, fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        )

        Text(
            text = "物布ID：${userId}",
            color = NormalFontColor,
            modifier = Modifier.constrainAs(id) {
                start.linkTo(userName.start)
                top.linkTo(userName.bottom)
                bottom.linkTo(head.bottom)
            },
            fontSize = 12.sp
        )
    }
}