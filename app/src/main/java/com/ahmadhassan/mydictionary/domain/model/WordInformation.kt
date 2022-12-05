package com.ahmadhassan.mydictionary.domain.model

import com.ahmadhassan.mydictionary.data.remote.dto.LicenseDTO
import com.ahmadhassan.mydictionary.data.remote.dto.MeaningDTO
import com.ahmadhassan.mydictionary.data.remote.dto.PhoneticDTO

/**
 * Created by Ahmad Hassan on 30/11/2022.
 */

data class WordInformation(
    val meanings: List<Meaning>,
    val phonetic: String?,
    val word: String,
)