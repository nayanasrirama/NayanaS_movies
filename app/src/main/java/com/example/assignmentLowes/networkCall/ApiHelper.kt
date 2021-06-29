package com.example.assignmentLowes.networkCall

import com.example.assignmentLowes.repository.model.MovieReviewModel

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 3:00 PM
 * */
class ApiHelper(private val apiService: RetroFitDataService) {

    suspend fun getMoviesList(): MovieReviewModel {
        return apiService.getMovieList("SkdmUs4EODcGyH3x1mgIHSMdTTUBQQ5p")
    }
}