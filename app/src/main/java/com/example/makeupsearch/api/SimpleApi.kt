package com.example.makeupsearch.api

import com.example.makeupsearch.model.MakeupInformation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {

    @GET("api/v1/products.json")
    suspend fun searchBrand(
            @Query("brand") brand: String
    ): Response<List<MakeupInformation>>

}