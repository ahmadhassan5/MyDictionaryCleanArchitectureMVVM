package com.ahmadhassan.mydictionary.data.util

import com.google.gson.Gson
import java.lang.reflect.Type

/**
 * Created by Ahmad Hassan on 01/12/2022.
 */

class GsonParser(
    private val gson: Gson
): JSONParser {
    override fun <T> fromJSON(json: String, type: Type): T? {
        return gson.fromJson(json, type)
    }

    override fun <T> toJSON(`object`: T, type: Type): String? {
        return gson.toJson(`object`, type)
    }
}