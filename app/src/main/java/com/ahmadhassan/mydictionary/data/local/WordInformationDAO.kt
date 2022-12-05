package com.ahmadhassan.mydictionary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahmadhassan.mydictionary.data.local.entity.WordInformationEntity
import com.ahmadhassan.mydictionary.domain.model.WordInformation

/**
 * Created by Ahmad Hassan on 01/12/2022.
 */

@Dao
interface WordInformationDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInformation(wordInformation: List<WordInformationEntity>)

    @Query("DELETE FROM WordInformationEntity WHERE Word IN (:words)")
    suspend fun deleteWordInformation(words: List<String>)

    @Query("SELECT * FROM WordInformationEntity WHERE Word LIKE '%' || :word || '%'")
    suspend fun getWordInformationList(word: String) : List<WordInformationEntity>

}