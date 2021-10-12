package com.example.justtestproject.remote.retrofit

import com.example.justtestproject.common.Constants
import com.example.justtestproject.presentation.ui.firstFragment.FirstFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class DataRepository : CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO

    companion object {
        lateinit var data: Any
    }

    private val dataApi = Retrofit.Builder()
        .baseUrl(Constants.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DataApi::class.java)

    fun getData() = async {
        dataApi.getData(page = 1, clientId = "sFU9rKMEnsqICAd3irqQph4Oxa0zuTtbpplmXLX5hgY",
            query = FirstFragment.word)
            .execute()
            .body()
            ?.results
    }
}