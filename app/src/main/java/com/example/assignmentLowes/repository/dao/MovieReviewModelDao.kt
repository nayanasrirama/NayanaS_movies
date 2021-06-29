package com.example.assignmentLowes.repository.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignmentLowes.repository.model.MovieReviewModel

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 4:00 PM
 * */
@Dao
interface MovieReviewModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(json: MovieReviewModel)

    @Query("select * from MovieReviewModel")
    fun getAllReviews(): LiveData<MovieReviewModel>

}