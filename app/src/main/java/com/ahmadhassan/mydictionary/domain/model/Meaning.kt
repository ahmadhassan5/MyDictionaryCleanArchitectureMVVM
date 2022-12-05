package com.ahmadhassan.mydictionary.domain.model

import com.ahmadhassan.mydictionary.data.remote.dto.DefinitionDTO

/**
 * Created by Ahmad Hassan on 30/11/2022.
 */

data class Meaning(
    val antonyms: List<Any>,
    val definitions: List<DefinitionDTO>,
    val partOfSpeech: String,
    val synonyms: List<String>,
)