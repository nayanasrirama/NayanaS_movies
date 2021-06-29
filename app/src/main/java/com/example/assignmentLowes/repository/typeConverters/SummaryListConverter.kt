package com.example.assignmentLowes.repository.typeConverters

import androidx.room.TypeConverter
import com.example.assignmentLowes.repository.model.SummaryModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 4:30 PM
 * */
class SummaryListConverter {
    @TypeConverter // note this annotation
    fun fromSummaryList(optionValues: List<SummaryModel>?): String? {
        if (optionValues == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<SummaryModel>>() {

        }.type
        return gson.toJson(optionValues, type)
    }

    @TypeConverter // note this annotation
    fun toSummaryList(optionValuesString: String?): List<SummaryModel>? {
        if (optionValuesString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<SummaryModel>>() {

        }.type
        return gson.fromJson<List<SummaryModel>>(optionValuesString, type)
    }
}
