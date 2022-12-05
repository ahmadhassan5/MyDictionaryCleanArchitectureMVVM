package com.ahmadhassan.mydictionary.data.util

import java.lang.reflect.Type

/**
 * Created by Ahmad Hassan on 01/12/2022.
 */

interface JSONParser {

    fun <T> fromJSON(json: String, type: Type): T?

    fun <T> toJSON(`object`: T, type: Type): String?
}