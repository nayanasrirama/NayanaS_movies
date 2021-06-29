package com.example.assignmentLowes.repository.model

import com.google.gson.annotations.SerializedName

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 3:30 PM
 * */
data class MultiMediaModel(
        @SerializedName("height") val height: Int,
        @SerializedName("src") val src: String,
        @SerializedName("type") val type: String,
        @SerializedName("width") val width: Int
)
