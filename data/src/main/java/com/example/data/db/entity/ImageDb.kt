package com.example.data.db.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.UUID

open class ImageDb : RealmObject()  {

    @PrimaryKey
    var id: Long? = null

    var index: Int? = null

    var description: String? = null

    var url: String? = null

}