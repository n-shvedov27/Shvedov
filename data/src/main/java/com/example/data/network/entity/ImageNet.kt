package com.example.data.network.entity

import com.google.gson.annotations.SerializedName

data class ImageNet(

    @SerializedName("id")
    val id: Long,

    @SerializedName("description")
    val description: String,

    @SerializedName("gifURL")
    val url: String

)