package com.example.assignmentLowes.repository.typeConverters

import androidx.room.TypeConverter
import com.example.assignmentLowes.repository.model.MultiMediaModel
import com.example.assignmentLowes.repository.model.SummaryModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 4:30 PM
 * */
class MultiMediaTypeConverter {

    @TypeConverter // note this annotation
    fun fromMultiMedia(optionValues: MultiMediaModel?): String? {
        if (optionValues == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<MultiMediaModel>() {

        }.type
        return gson.toJson(optionValues, type)
    }

    @TypeConverter // note this annotation
    fun toMultiMedia(optionValuesString: String?): MultiMediaModel? {
        if (optionValuesString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<SummaryModel>>() {

        }.type
        return gson.fromJson<MultiMediaModel>(optionValuesString, type)
    }
}