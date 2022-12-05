package com.ahmadhassan.mydictionary.domain.use_case

import com.ahmadhassan.mydictionary.data.remote.dto.WordInformationDTO
import com.ahmadhassan.mydictionary.domain.model.WordInformation
import com.ahmadhassan.mydictionary.domain.repository.WordInformationRepository
import com.ahmadhassan.mydictionary.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Ahmad Hassan on 01/12/2022.
 */

class GetWordInformation(
    private val repository: WordInformationRepository
) {

    operator fun invoke(word: String): Flow<Resource<List<WordInformation>>> {
        if (word.isBlank()){
            return flow {  }
        }
        return repository.getWordInformation(word)
    }
}