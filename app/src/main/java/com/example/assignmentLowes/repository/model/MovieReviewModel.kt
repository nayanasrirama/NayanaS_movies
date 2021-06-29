package com.example.assignmentLowes.repository.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.assignmentLowes.repository.typeConverters.SummaryListConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 3:30 PM
 * */

@Entity
data class MovieReviewModel(
        @PrimaryKey(autoGenerate = true)
        @NonNull
        val id: Int,
        @SerializedName("status") val status: String,
        @SerializedName("copyright") val copyright: String,
        @SerializedName("has_more") val hasMore: Boolean,
        @SerializedName("num_results") val total: Int,
        @SerializedName("results")
        @TypeConverters(SummaryListConverter::class)
        @Expose
        val summaryModel: List<SummaryModel>
)


