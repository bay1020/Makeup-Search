package com.example.makeupsearch.repository

import com.example.makeupsearch.api.RetrofitInstance
import com.example.makeupsearch.model.MakeupInformation
import retrofit2.Response

class Repository {

    suspend fun getMakeupInformation(brand: String): Response<List<MakeupInformation>> {
        return RetrofitInstance.api.searchBrand(brand)
    }

}