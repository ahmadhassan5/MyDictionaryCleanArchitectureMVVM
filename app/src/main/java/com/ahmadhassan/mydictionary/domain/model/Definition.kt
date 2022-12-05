package com.ahmadhassan.mydictionary.domain.model

/**
 * Created by Ahmad Hassan on 30/11/2022.
 */

data class Definition(
    val antonyms: List<Any>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>,
)