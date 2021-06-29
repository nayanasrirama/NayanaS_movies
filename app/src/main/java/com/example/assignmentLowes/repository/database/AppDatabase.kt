package com.example.assignmentLowes.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.assignmentLowes.repository.dao.MovieReviewModelDao
import com.example.assignmentLowes.repository.dao.MovieSummaryDao
import com.example.assignmentLowes.repository.model.MovieReviewModel
import com.example.assignmentLowes.repository.model.SummaryModel
import com.example.assignmentLowes.repository.typeConverters.LinkTypeConverter
import com.example.assignmentLowes.repository.typeConverters.MultiMediaTypeConverter
import com.example.assignmentLowes.repository.typeConverters.SummaryListConverter

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 11:00 PM
 * */
@TypeConverters(
        SummaryListConverter::class, LinkTypeConverter::class, MultiMediaTypeConverter::class
)
@Database(entities = [MovieReviewModel::class, SummaryModel::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {

    abstract fun MovieReviewModelDao(): MovieReviewModelDao
    abstract fun MoviewSummaryDao(): MovieSummaryDao

    companion object {

        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {

            if (instance == null) {
                synchronized(AppDatabase::class.java) {
                    instance = Room.databaseBuilder(context, AppDatabase::class.java, "MoviewReviewdb")
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return instance!!
        }
    }
}