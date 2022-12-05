package com.ahmadhassan.mydictionary.data.remote.dto

import com.ahmadhassan.mydictionary.data.local.entity.WordInformationEntity
import com.ahmadhassan.mydictionary.domain.model.Definition
import com.ahmadhassan.mydictionary.domain.model.Meaning
import com.ahmadhassan.mydictionary.domain.model.WordInformation

data class WordInformationDTO(
    val license: LicenseDTO,
    val meanings: List<MeaningDTO>,
    val phonetic: String?,
    val phonetics: List<PhoneticDTO>,
    val sourceUrls: List<String>,
    val word: String,
) {
    fun toWordInformationEntity() : WordInformationEntity {
        return WordInformationEntity(

            meanings = meanings.map { it.toMeaning() },
            phonetic = phonetic,
            word = word
        )
    }
}

data class LicenseDTO(
    val name: String,
    val url: String,
)

data class MeaningDTO(
    val antonyms: List<String>,
    val definitions: List<DefinitionDTO>,
    val partOfSpeech: String,
    val synonyms: List<String>,
){
    fun toMeaning() : Meaning {
        return Meaning(
            antonyms = antonyms,
            definitions = definitions,
            partOfSpeech = partOfSpeech,
            synonyms = synonyms
        )
    }
}

data class DefinitionDTO(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>,
) {
    fun toDefinition(): Definition {
        return Definition(
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}

data class PhoneticDTO(
    val audio: String,
    val license: LicenseDTO,
    val sourceUrl: String,
    val text: String,
)

