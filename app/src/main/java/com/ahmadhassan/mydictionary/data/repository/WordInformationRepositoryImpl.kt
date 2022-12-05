package com.ahmadhassan.mydictionary.data.repository

import android.util.Log
import com.ahmadhassan.mydictionary.data.local.WordInformationDAO
import com.ahmadhassan.mydictionary.data.remote.DictionaryAPI
import com.ahmadhassan.mydictionary.domain.model.WordInformation
import com.ahmadhassan.mydictionary.domain.repository.WordInformationRepository
import com.ahmadhassan.mydictionary.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by Ahmad Hassan on 01/12/2022.
 */

class WordInformationRepositoryImpl(
    private val api: DictionaryAPI,
    private val dao: WordInformationDAO
): WordInformationRepository {

    override fun getWordInformation(word: String): Flow<Resource<List<WordInformation>>> = flow {
        emit(Resource.Loading())

        val wordInformations = dao.getWordInformationList(word).map { it.toWordInformation() }
        emit(Resource.Loading(data = wordInformations))
        try {
            val remoteWordInformations = api.getWordInformation(word)
            dao.deleteWordInformation(remoteWordInformations.map { it.word })
            dao.insertWordInformation(remoteWordInformations.map { it.toWordInformationEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Something went wrong!",
                data = wordInformations
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check internet connection!",
                data = wordInformations
            ))
        }

        val newWordInformations = dao.getWordInformationList(word).map { it.toWordInformation() }
        emit(Resource.Success(newWordInformations))

    }
}