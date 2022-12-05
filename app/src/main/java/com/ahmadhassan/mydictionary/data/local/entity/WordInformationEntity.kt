package com.ahmadhassan.mydictionary.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ahmadhassan.mydictionary.domain.model.Meaning
import com.ahmadhassan.mydictionary.domain.model.WordInformation

/**
 * Created by Ahmad Hassan on 01/12/2022.
 */

@Entity
data class WordInformationEntity(

    @ColumnInfo(name = "Id")
    @PrimaryKey
    val id: Int? = null,
    @ColumnInfo(name = "Meanings")
    val meanings: List<Meaning>,
    @ColumnInfo(name = "Phonetic")
    val phonetic: String?,
    @ColumnInfo(name = "Word")
    val word: String,

) {
    fun toWordInformation() : WordInformation {
        return WordInformation(
            meanings = meanings,
            phonetic = phonetic,
            word = word
        )
    }
}
