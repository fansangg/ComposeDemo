package com.example.compose.bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class UserInfo(@SerializedName("nickName") val name:String, @SerializedName("userIcon")val head:String, @SerializedName("userNo")val id:String):Serializable
