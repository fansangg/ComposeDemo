package com.example.compose.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R

@Composable
fun DemoCode(){
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(Modifier.padding(start = 20.dp,end = 20.dp,top = 5.dp)) {
            Text(
                text = "This Is JetPack Compose Demo", color = Color.Cyan,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.LineThrough,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            Image(
                painter = painterResource(id = R.drawable.arte_1611914351391),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                "title、title、title、title、title、title、title、title、",
                style = typography.h6,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                "sub title、sub title、sub title、sub title",
                style = typography.body2,
                textDecoration = TextDecoration.Underline
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                "内容、内容、内容、内容、内容、内容、内容、内容、内容、内容、内容、内容、内容、内容、内容、内容、内容、内容、内容、内容",
                style = typography.body2
            )
        }
    }
}