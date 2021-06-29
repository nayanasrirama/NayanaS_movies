package com.example.assignmentLowes.repository.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.assignmentLowes.repository.typeConverters.LinkTypeConverter
import com.example.assignmentLowes.repository.typeConverters.MultiMediaTypeConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 3:30 PM
 * */
@Entity
data class SummaryModel(
        @PrimaryKey(autoGenerate = true)
        @NonNull
        val id: Int,
        @SerializedName("byline") val byline: String,
        @SerializedName("critics_pick") val criticsPick: Int,
        @SerializedName("date_updated") val dateUpdated: String,
        @SerializedName("display_title") val displayTitle: String,
        @SerializedName("headline") val headline: String,
        @SerializedName("mpaa_rating") val mpaaRating: String,
        @SerializedName("opening_date") val openingDate: String,
        @SerializedName("publication_date") val publicationDate: String,
        @SerializedName("summary_short") val summaryShort: String,
        @SerializedName("link")
        @Expose
        @TypeConverters(LinkTypeConverter::class)
        val link: LinkModel,
        @SerializedName("multimedia")
        @Expose
        @TypeConverters(MultiMediaTypeConverter::class)
        val multimedia: MultiMediaModel
) : Serializable