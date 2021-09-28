package com.example.justtestproject.remote.retrofit

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

//class ApiRepository: CoroutineScope {
//    override val coroutineContext: CoroutineContext = Dispatchers.IO
//
//    private val dataApi = Retrofit.Builder()
//        .baseUrl("https://api.unsplash.com/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(DataApi::class.java)
//
//
//
//    fun getWeather() = async {
//        dataApi.getData(page = 1, clientId = "sFU9rKMEnsqICAd3irqQph4Oxa0zuTtbpplmXLX5hgY", query = FirstFragment().word)
//            .execute()
//            .body()
//            ?.weathers
//    }
//}