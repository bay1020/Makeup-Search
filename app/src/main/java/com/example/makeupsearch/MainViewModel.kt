package com.example.makeupsearch

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makeupsearch.model.MakeupInformation
import com.example.makeupsearch.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

private const val TAG = "MainViewModel"

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<List<MakeupInformation>>> = MutableLiveData()

    fun getPost(brand: String) {
        viewModelScope.launch {
            val response = repository.getMakeupInformation(brand)
            val getResponseBody = response.body() ?: listOf()
            Log.d(TAG, "getPost: body is $getResponseBody")
            for (r in getResponseBody) {
                Log.d(TAG, "get image data is ${r.image_link}")
                Log.d(TAG, "get name is ${r.name}")
            }
            myResponse.value = response

        }
    }
}