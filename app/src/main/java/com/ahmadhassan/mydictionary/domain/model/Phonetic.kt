package com.ahmadhassan.mydictionary.domain.model

import com.ahmadhassan.mydictionary.data.remote.dto.LicenseDTO

/**
 * Created by Ahmad Hassan on 30/11/2022.
 */

data class Phonetic(
    val audio: String,
    val license: LicenseDTO,
    val sourceUrl: String,
    val text: String,
)
