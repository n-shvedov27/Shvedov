package com.example.sirius.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ImageItem(

    val id: Long,

    val url: String,

    val description: String

) : Parcelable