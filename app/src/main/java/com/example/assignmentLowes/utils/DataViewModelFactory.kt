package com.example.assignmentLowes.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignmentLowes.repository.DataRepository

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 11:00 PM
 */
class DataViewModelFactory(private val context: Context) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        try {
            return modelClass.getConstructor(DataRepository::class.java)
                    .newInstance(DataRepository.getInstance(context)) as T
        } catch (e: InstantiationException) {
            throw RuntimeException("Cannot create an instance of $modelClass", e)
        } catch (e: IllegalAccessException) {
            throw RuntimeException("Cannot create an instance of $modelClass", e)
        }
    }

}