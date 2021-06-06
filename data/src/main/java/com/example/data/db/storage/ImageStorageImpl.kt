package com.example.data.db.storage

import com.example.data.db.entity.ImageDb
import io.realm.Realm
import javax.inject.Inject

class ImageStorageImpl @Inject constructor(

) : ImageStorage {

    private fun <T> useRealm(query: Realm.() -> T) : T = Realm.getDefaultInstance().use(query)

    private fun useTransaction(query: Realm.() -> Unit): Unit = useRealm {
        executeTransaction(query)
    }

    override fun save(model: ImageDb) = useTransaction { copyToRealmOrUpdate(model) }

    override fun getByIndex(index: Int): ImageDb? = useRealm {

        val item = where(ImageDb::class.java).equalTo("index", index).findFirst()

        item ?: return@useRealm null

        return@useRealm copyFromRealm(item)
    }
}