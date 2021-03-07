package com.example.makeupsearch.repository

import com.example.makeupsearch.api.RetrofitInstance
import com.example.makeupsearch.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(brand: String): Response<List<Post>> {
        return RetrofitInstance.api.getPost(brand)
    }

}