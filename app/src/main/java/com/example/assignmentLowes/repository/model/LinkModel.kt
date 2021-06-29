package com.example.assignmentLowes.repository.model

import com.google.gson.annotations.SerializedName

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 3:30 PM
 * */

data class LinkModel(
        @SerializedName("suggested_link_text") val linkText: String,
        @SerializedName("type") val type: String,
        @SerializedName("url") val url: String
)