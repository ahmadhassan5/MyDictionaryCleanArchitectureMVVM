package com.ahmadhassan.mydictionary.di

import android.app.Application
import androidx.room.Room
import com.ahmadhassan.mydictionary.data.local.TypeConverter
import com.ahmadhassan.mydictionary.data.local.WordInformationDatabase
import com.ahmadhassan.mydictionary.data.remote.DictionaryAPI
import com.ahmadhassan.mydictionary.data.repository.WordInformationRepositoryImpl
import com.ahmadhassan.mydictionary.data.util.GsonParser
import com.ahmadhassan.mydictionary.domain.repository.WordInformationRepository
import com.ahmadhassan.mydictionary.domain.use_case.GetWordInformation
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Ahmad Hassan on 02/12/2022.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetWordInformationUseCase(repository: WordInformationRepository): GetWordInformation {
        return GetWordInformation(repository)
    }

    @Provides
    @Singleton
    fun provideWordInformationRepository(api: DictionaryAPI, database: WordInformationDatabase): WordInformationRepository {
        return WordInformationRepositoryImpl(api, database.wordInformationDAO)
    }

    @Provides
    @Singleton
    fun provideWordInformationDatabase(app: Application): WordInformationDatabase {
        return Room.databaseBuilder(
            app,
            WordInformationDatabase::class.java,
            "word_information_database"
        ).addTypeConverter(TypeConverter(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryAPI(): DictionaryAPI {
        return Retrofit.Builder()
            .client(OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor()).build())
            .baseUrl("https://api.dictionaryapi.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryAPI::class.java)
    }
}