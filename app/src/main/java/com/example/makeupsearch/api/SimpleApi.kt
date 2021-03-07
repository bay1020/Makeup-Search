package com.example.makeupsearch.api

import com.example.makeupsearch.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {

    @GET("api/v1/products.json")
    suspend fun getPost(
            @Query("brand") brand: String
    ): Response<List<Post>>

}