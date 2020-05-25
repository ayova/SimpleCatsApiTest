package com.ayova.catsapitest.api

import com.ayova.catsapitest.models.RandomCats
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CatsApiService {
    /**
     * Gets 16 cat images by default (set by limit)
     */
    @Headers("x-api-key:${CatsApi.API_KEY}")
    @GET("images/search")
    fun getRandImage(@Query("limit") limit: Int = 16): Call<RandomCats>

}