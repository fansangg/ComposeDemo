package com.example.compose

import android.content.Context
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.ui.theme.MyApplicationTheme
import com.google.accompanist.coil.CoilImage
import com.google.accompanist.coil.rememberCoilPainter

class MainActivity : ComponentActivity() {
    private val userInfoList: MutableList<UserInfo> by lazy {
        mutableListOf(
            UserInfo(
                "金角大王",
                "https://oss.sceneconsole.cn/avatar/156084790/9571341A-2A82-4DFB-85A1-E210E09D2371.jpg"
            ),
            UserInfo(
                "蟹老板家的蟹黄堡最好吃",
                "https://arte.oss-cn-beijing.aliyuncs.com/avatar/156085168/C322C661-C22B-43F7-913B-2ABE8D9C42D5.jpg"
            ),
            UserInfo(
                "你瞅啥",
                "https://oss.sceneconsole.cn/avatar/156084685/502FD4F7-E2FB-480E-9CFA-2FCB492B24AF.jpg"
            ),
            UserInfo(
                "后自以为是不懂自己在生活",
                "https://oss.sceneconsole.cn/avatar/156082426/9855DE0F-32A7-4D17-8DED-5CD2E6EC3BD7.jpg"
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                ShowContent()
                Spacer(modifier = Modifier.height(20.dp))
                TopTitle(this@MainActivity)
                Content(userInfoList)
            }

        }
    }
}

@Composable
fun ShowContent() {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(Modifier.padding(20.dp)) {
            Text(
                text = "JetPack Compose", color = Color.Cyan,
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
            Text("sub title、sub title、sub title、sub title", style = typography.body2)
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                "content、content、contentcontentcontentcontentcontentcontentcontentcontent",
                style = typography.body2
            )
        }
    }
}

@Composable
fun TopTitle(context: Context) {
    ConstraintLayout(
        modifier = Modifier
            .background(color = Color(0xff211536))
            .fillMaxWidth()
            .height(65.dp)
    ) {
        val (button, text) = createRefs()
        IconButton(
            onClick = { Toast.makeText(context, "back", Toast.LENGTH_SHORT).show() },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top)
                start.linkTo(parent.start, margin = 5.dp)
                bottom.linkTo(parent.bottom)
            }) {
            Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = "")
        }

        Text(text = "TA们也在这里", modifier = Modifier.constrainAs(text) {
            centerHorizontallyTo(parent)
            centerVerticallyTo(parent)
        }, fontSize = 15.sp, color = Color(0xfff2f2f9), fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun Content(userInfoList: MutableList<UserInfo>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0XFF1D182F))
    ) {
        TopHead(userInfoList = userInfoList)
    }
}

@Composable
fun TopHead(userInfoList: MutableList<UserInfo>) {
    var followState by remember {
        mutableStateOf(false)
    }

    Card(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp)),
        backgroundColor = Color(0xff3a304e),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(Modifier.padding(bottom = 20.dp)) {
            ConstraintLayout(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth()
            ) {
                val (head, name, id, vIcon, followBtn, crown) = createRefs()
                Image(
                    painter = painterResource(id = R.drawable.poi_crown_big),
                    contentDescription = "",
                    modifier = Modifier.constrainAs(crown) {
                        linkTo(
                            start = head.start,
                            end = head.end,
                            top = parent.top,
                            bottom = head.top,
                            topMargin = 25.dp
                        )
                    })
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .border(width = 2.dp, Color.White, shape = RoundedCornerShape(25.dp))
                        .constrainAs(head) {
                            start.linkTo(parent.start, 30.dp)
                            top.linkTo(parent.top, 38.dp)
                        }, contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = rememberCoilPainter(request = "https://oss.sceneconsole.cn/avatar/156085155/D967F72C-AD5D-4EF0-A88F-5AA81374D3AE.jpg"),
                        contentDescription = "",
                        Modifier
                            .size(48.dp)
                            .clip(RoundedCornerShape(24.dp)),
                        contentScale = ContentScale.Crop
                    )
                }

                Text(
                    text = "Sara是个咖啡师",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp,
                    color = Color(0xfff2f2f9),
                    modifier = Modifier
                        .constrainAs(name) {
                            start.linkTo(head.end, 8.dp)
                            top.linkTo(head.top)
                            bottom.linkTo(id.top)
                        },
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Image(painter = painterResource(id = R.drawable.star_v),
                    contentDescription = "v",
                    Modifier
                        .wrapContentSize()
                        .constrainAs(vIcon) {
                            start.linkTo(name.end, 3.dp)
                            centerVerticallyTo(name)
                        }
                )

                Text(text = "物布ID：123456",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = Color(0xffc7c7d4),
                    modifier = Modifier.constrainAs(id) {
                        top.linkTo(name.bottom)
                        start.linkTo(name.start)
                        bottom.linkTo(head.bottom)
                    }

                )

                val followColor = Color(0x1aa0a0aa)
                val unFollowColor = Color(0x66211536)

                Box(modifier = Modifier
                    .width(80.dp)
                    .height(30.dp)
                    .constrainAs(followBtn) {
                        end.linkTo(parent.end, 30.dp)
                        centerVerticallyTo(head)
                    }.clickable {
                        followState = !followState
                    }
                    .background(if (followState) followColor else unFollowColor, shape = RoundedCornerShape(14.dp)),
                    contentAlignment = Alignment.Center) {
                    Text(
                        text = if (followState) "已关注" else "未关注", fontSize = 12.sp, fontWeight = FontWeight.SemiBold,
                        color = Color(0xfff2f2f9)
                    )
                }
            }

            Row(modifier = Modifier.padding(start = 17.dp, end = 17.dp)) {
                userInfoList.forEach {
                    UserHead(url = it.head, name = it.name)
                }
            }
        }
    }

}

@Composable
fun UserHead(url: String, name: String) {
    Column(Modifier.width(72.dp)) {
        Image(
            painter = rememberCoilPainter(request = url),
            contentDescription = "head",
            modifier = Modifier
                .size(48.dp)
                .clip(shape = RoundedCornerShape(24.dp))
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = name,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color(0xfff2f2f9),
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
fun PreviewContent() {
    ShowContent()
}
