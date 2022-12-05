package com.ahmadhassan.mydictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ahmadhassan.mydictionary.data.util.JSONParser
import com.ahmadhassan.mydictionary.domain.model.Meaning
import com.google.gson.reflect.TypeToken

/**
 * Created by Ahmad Hassan on 01/12/2022.
 */

@ProvidedTypeConverter
class TypeConverter(
    private val jsonParser: JSONParser
) {

    @TypeConverter
    fun fromMeaningJSON(json: String) : List<Meaning> {
        return jsonParser.fromJSON<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningJSON(list: List<Meaning>): String {
        return jsonParser.toJSON(
            list,
            object : TypeToken<ArrayList<Meaning>>(){}.type) ?: "[]"
    }
}