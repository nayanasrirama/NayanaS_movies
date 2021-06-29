package com.example.assignmentLowes.repository.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignmentLowes.repository.model.SummaryModel

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 4:00 PM
 * */
@Dao
interface MovieSummaryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(json: List<SummaryModel>)

    @Query("select * from SummaryModel")
    fun getAllReviews(): LiveData<List<SummaryModel>>
}