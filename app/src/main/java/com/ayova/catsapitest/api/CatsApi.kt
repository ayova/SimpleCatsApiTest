package com.ayova.catsapitest.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatsApi {
    val API_URL = "https://api.thecatapi.com/v1/"
    const val API_KEY = "5c8f07f7-03c7-482f-a547-b0bfabd65c79"
    lateinit var service: CatsApiService

    fun initService() {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(CatsApiService::class.java)
    }
}