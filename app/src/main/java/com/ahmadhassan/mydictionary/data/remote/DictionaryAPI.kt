package com.ahmadhassan.mydictionary.data.remote

import com.ahmadhassan.mydictionary.data.remote.dto.WordInformationDTO
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Ahmad Hassan on 30/11/2022.
 */

interface DictionaryAPI {

    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordInformation(
        @Path("word") word: String
    ) : List<WordInformationDTO>
}