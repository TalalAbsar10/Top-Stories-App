package com.example.egym.topstories.data.data_source.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.egym.topstories.data.data_source.dto.top_stories_details_dto.Result
import com.example.egym.topstories.util.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Result> {
        return jsonParser.fromJson<ArrayList<Result>>(
            json,
            object : TypeToken<ArrayList<Result>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Result>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Result>>(){}.type
        ) ?: "[]"
    }
}