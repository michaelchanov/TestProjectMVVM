package com.example.justtestproject.data.remote.retrofit

import com.example.justtestproject.common.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class DataRepository : CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO

    companion object {
        fun retrofitInstance() = Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DataApi::class.java)

    }
}