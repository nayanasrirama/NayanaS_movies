package com.example.assignmentLowes.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.assignmentLowes.networkCall.ApiHelper
import com.example.assignmentLowes.networkCall.RetrofitBuilder
import com.example.assignmentLowes.repository.dao.MovieReviewModelDao
import com.example.assignmentLowes.repository.dao.MovieSummaryDao
import com.example.assignmentLowes.repository.database.AppDatabase
import com.example.assignmentLowes.repository.model.MovieReviewModel

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 11:00 PM
 * Handles data sources and execute on the correct threads.
 */
class DataRepository(private val movieReviewModelDao: MovieReviewModelDao, private val summaryDao: MovieSummaryDao) {


    private val apiHelper: ApiHelper = ApiHelper(RetrofitBuilder.apiService)

    companion object {
        @Volatile
        private var instance: DataRepository? = null

        fun getInstance(context: Context): DataRepository? {
            return instance ?: synchronized(DataRepository::class.java) {
                if (instance == null) {
                    val database = AppDatabase.getInstance(context)
                    instance = DataRepository(database.MovieReviewModelDao(), database.MoviewSummaryDao())
                }
                return instance
            }
        }

    }

    suspend fun getMovieList(): MovieReviewModel = apiHelper.getMoviesList()

    fun getAllReviews(): LiveData<MovieReviewModel> {
        return movieReviewModelDao.getAllReviews()
    }

    suspend fun insertAll(response: MovieReviewModel) {
        movieReviewModelDao.insertAll(response)
    }

}
