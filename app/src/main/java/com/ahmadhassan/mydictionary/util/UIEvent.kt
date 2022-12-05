package com.ahmadhassan.mydictionary.util

/**
 * Created by Ahmad Hassan on 27/11/2022.
 */

sealed class UIEvent {
    object PopBackStack: UIEvent()
    data class Navigate(val route: String): UIEvent()
    data class ShowSnackBar(
        val message: String,
        val action: String? = null
    ): UIEvent()
}
