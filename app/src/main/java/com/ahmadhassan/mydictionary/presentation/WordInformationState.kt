package com.ahmadhassan.mydictionary.presentation

import com.ahmadhassan.mydictionary.domain.model.WordInformation
import com.ahmadhassan.mydictionary.util.Resource

/**
 * Created by Ahmad Hassan on 02/12/2022.
 */

data class WordInformationState(
    val wordInformationItems: List<WordInformation> = emptyList(),
    val isLoading: Boolean = false
)