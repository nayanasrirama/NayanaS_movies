package com.example.assignmentLowes.repository.typeConverters

import androidx.room.TypeConverter
import com.example.assignmentLowes.repository.model.LinkModel
import com.example.assignmentLowes.repository.model.SummaryModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 4:30 PM
 * */
class LinkTypeConverter {

    @TypeConverter // note this annotation
    fun fromLink(optionValues: LinkModel?): String? {
        if (optionValues == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<LinkModel>() {

        }.type
        return gson.toJson(optionValues, type)
    }

    @TypeConverter // note this annotation
    fun toLink(optionValuesString: String?): LinkModel? {
        if (optionValuesString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<SummaryModel>>() {

        }.type
        return gson.fromJson<LinkModel>(optionValuesString, type)
    }
}