package com.example.assignmentLowes.views.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignmentLowes.repository.DataRepository
import com.example.assignmentLowes.repository.model.MovieReviewModel
import com.example.assignmentLowes.repository.model.SummaryModel
import kotlinx.coroutines.*

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 11:12 AM
 * ViewModel is also called as SharedViewModel
 * Fetches the data using coroutines & update UI
 */

class BaseViewModel(private val dataRepository: DataRepository) : ViewModel() {

    private val errorMessage = MutableLiveData<String>()
    var movieReviewList: LiveData<MovieReviewModel> = dataRepository.getAllReviews()
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()
    lateinit var summaryModel: SummaryModel

    fun getMoviesList() {
        loading.value = true
        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = dataRepository.getMovieList()
            withContext(Dispatchers.Main) {
                if (response.status == "OK") {
                    println("Success ${response.status}")
                    dataRepository.insertAll(response)
                    loading.value = false
                } else {
                    onError("Error : Api Error occurred ")
                }

            }
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

}