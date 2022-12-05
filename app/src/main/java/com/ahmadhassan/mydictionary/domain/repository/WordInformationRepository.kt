package com.ahmadhassan.mydictionary.domain.repository

import com.ahmadhassan.mydictionary.domain.model.WordInformation
import com.ahmadhassan.mydictionary.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ahmad Hassan on 01/12/2022.
 */

interface WordInformationRepository {

    fun getWordInformation(word: String): Flow<Resource<List<WordInformation>>>
}