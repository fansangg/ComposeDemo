package com.example.compose.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.SizeUtils
import com.example.compose.R
import com.example.compose.bean.UserInfo
import com.example.compose.ui.theme.NormalFontColor
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun Content(userData:List<UserInfo>,moreClick:(() -> Unit)) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0XFF1D182F))
    ) {
        HeadCard(userData,moreClick)
        BigCell{

        }
    }
}


@Composable
fun HeadCard(userData:List<UserInfo>,moreClick:(() -> Unit)) {

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
        shape = RoundedCornerShape(12.dp),
        elevation = 1.dp
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
                    text = "Sara???????????????",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp,
                    color = NormalFontColor,
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

                Text(text = "??????ID???123456",
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

                Button(
                    onClick = { followState = !followState }, modifier = Modifier
                        .width(80.dp)
                        .height(30.dp)
                        .constrainAs(followBtn) {
                            end.linkTo(parent.end, 30.dp)
                            centerVerticallyTo(head)
                        }, shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (followState) followColor else unFollowColor),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 0.dp
                    )
                ) {
                    Text(
                        text = if (followState) "?????????" else "?????????",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = NormalFontColor
                    )
                }
            }

            val count = (ScreenUtils.getScreenWidth() - SizeUtils.dp2px(34.dp.value)).div(SizeUtils.dp2px(72.dp.value))
            val filterList = userData.filterIndexed { index, _ ->
                index < count
            }
            Row(modifier = Modifier.padding(start = 17.dp, end = 17.dp)) {
                filterList.forEachIndexed { index, userInfo ->
                    if (index != count - 1)
                        UserHead(url = userInfo.head, name = userInfo.name)
                    else MoreBtn(moreClick)
                }
            }
        }
    }

}

@Composable
fun MoreBtn(block:(() -> Unit)) {
    Column(
        Modifier
            .wrapContentHeight()
            .width(72.dp)
            .clickable {
                block()
            }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(72.dp)) {
            Image(
                painter = painterResource(id = R.drawable.bg_poi_yinying),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )

            Image(
                painter = painterResource(id = R.drawable.ic_poi_more),
                contentDescription = "head",
                modifier = Modifier
                    .wrapContentSize()
            )
        }

        Text(
            text = "??????",
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = NormalFontColor,
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun UserHead(url: String, name: String) {
    Column(
        Modifier
            .width(72.dp)
            .wrapContentHeight()
    ) {
        Box(modifier = Modifier.size(72.dp), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.bg_poi_yinying),
                contentDescription = "",
                modifier = Modifier.size(72.dp)
            )

            Image(
                painter = rememberCoilPainter(request = url),
                contentDescription = "head",
                modifier = Modifier
                    .size(48.dp)
                    .clip(shape = RoundedCornerShape(24.dp))
            )
        }

        Text(
            text = name,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = NormalFontColor,
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun BigCell(click: () -> Unit) {

    Column(modifier = Modifier.background(Color(0XFF1D182F))) {
        Spacer(
            modifier = Modifier
                .height(8.dp)
                .fillMaxWidth()
        )
        Card(
            elevation = 1.dp,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            backgroundColor = Color(0xff3a304e),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(18.dp)
                )
                Text(
                    text = "???????????????",
                    fontSize = 14.sp,
                    color = NormalFontColor,
                    modifier = Modifier.padding(start = 16.dp),
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(14.dp))
                val imgSize = SizeUtils.px2dp(
                    ScreenUtils.getScreenWidth().toFloat()
                ) - 16.dp.value - 32.dp.value
                Button(
                    onClick = { click.invoke() },
                    elevation = ButtonDefaults.elevation(0.dp, 0.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(Dp(imgSize))
                ) {
                    Card(
                        elevation = 1.dp,
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ConstraintLayout {
                            val (likeContainer, arteType, headContainer, shadowBg) = createRefs()
                            Image(
                                painter = rememberCoilPainter(request = "https://oss.sceneconsole.cn/156084821/image/1933D188-992C-4BCF-9F54-90863D03EDD1.png"),
                                contentDescription = "",
                                Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )

                            Row(
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .height(32.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(color = Color(0x33000000))
                                    .padding(start = 10.dp, end = 10.dp)
                                    .constrainAs(likeContainer) {
                                        top.linkTo(parent.top, margin = 12.dp)
                                        start.linkTo(parent.start, margin = 12.dp)
                                    }, verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.poi_crown_big),
                                    contentDescription = "crown",
                                    modifier = Modifier.size(22.dp, 16.dp)
                                )
                                Spacer(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(7.dp)
                                )
                                Text(
                                    text = "99???", fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = NormalFontColor
                                )
                            }

                            Image(painter = painterResource(id = R.drawable.video),
                                contentDescription = "typeVideo",
                                modifier = Modifier
                                    .size(32.dp)
                                    .constrainAs(arteType) {
                                        bottom.linkTo(likeContainer.bottom)
                                        end.linkTo(parent.end)
                                    }
                            )

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = listOf(
                                                Color.Transparent, Color(0xcc000000)
                                            )
                                        )
                                    )
                                    .constrainAs(shadowBg) {
                                        bottom.linkTo(parent.bottom)
                                    }
                            )

                            ConstraintLayout(modifier = Modifier
                                .height(34.dp)
                                .constrainAs(headContainer) {
                                    start.linkTo(parent.start, 10.dp)
                                    bottom.linkTo(parent.bottom, 11.dp)
                                }) {
                                val (head, name, slogan, vIcon) = createRefs()
                                Image(painter = rememberCoilPainter(request = "https://oss.sceneconsole.cn/avatar/156084821/B29F5399-4FAE-4C65-91AD-F3ADF277042E.jpg"),
                                    contentDescription = "userHead",
                                    modifier = Modifier
                                        .size(
                                            34.dp
                                        )
                                        .clip(shape = CircleShape)
                                        .constrainAs(head) {
                                            start.linkTo(parent.start)
                                            top.linkTo(parent.top)
                                        })
                                Text(
                                    text = "Sara???????????????",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = NormalFontColor,
                                    modifier = Modifier.constrainAs(name) {
                                        start.linkTo(head.end, 6.dp)
                                        top.linkTo(head.top)
                                        bottom.linkTo(slogan.top)
                                    })

                                Text(
                                    text = "??????????????????????????????",
                                    color = NormalFontColor,
                                    fontSize = 12.sp,
                                    modifier = Modifier.constrainAs(slogan) {
                                        start.linkTo(name.start)
                                        top.linkTo(name.bottom)
                                        bottom.linkTo(head.bottom)
                                    })

                                Image(
                                    painter = painterResource(id = R.drawable.star_v),
                                    contentDescription = "v",
                                    modifier = Modifier.constrainAs(vIcon) {
                                        start.linkTo(name.end)
                                        top.linkTo(name.top)
                                        bottom.linkTo(name.bottom)
                                    })
                            }


                        }

                    }
                }
            }
        }
    }
}