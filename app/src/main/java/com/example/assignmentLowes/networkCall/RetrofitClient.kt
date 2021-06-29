package com.example.assignmentLowes.networkCall

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 3:00 PM
 * */
object RetrofitBuilder {

    private val BASE_URL = "https://api.nytimes.com"

    private val customHttpLogger: HttpLoggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {

        override fun log(message: String) {
            println(message)
        }
    })

    private val httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(customHttpLogger.setLevel(
            HttpLoggingInterceptor.Level.BODY))

    private val okHttpClient: OkHttpClient = httpClientBuilder.build()

    private val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(okHttpClient)
            .build()

    val apiService: RetroFitDataService = api.create(RetroFitDataService::class.java)
}