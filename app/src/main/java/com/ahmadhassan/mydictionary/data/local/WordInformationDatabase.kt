package com.ahmadhassan.mydictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ahmadhassan.mydictionary.data.local.entity.WordInformationEntity

/**
 * Created by Ahmad Hassan on 01/12/2022.
 */

@Database(
    entities = [WordInformationEntity::class],
    version = 1
)
@TypeConverters(TypeConverter::class)
abstract class WordInformationDatabase: RoomDatabase() {

    abstract val wordInformationDAO: WordInformationDAO

}