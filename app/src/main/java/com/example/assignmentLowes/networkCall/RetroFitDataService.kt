package com.example.assignmentLowes.networkCall

import com.example.assignmentLowes.repository.model.MovieReviewModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 3:00 PM
 * */
interface RetroFitDataService {

    @GET("/svc/movies/v2/reviews/all.json")
    suspend fun getMovieList(@Query("api-key") apiKey: String): MovieReviewModel

}