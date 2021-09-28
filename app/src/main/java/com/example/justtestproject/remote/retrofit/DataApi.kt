package com.example.justtestproject.remote.retrofit

import com.example.justtestproject.remote.json_objects.MainData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DataApi {

    @GET("/search/photos")
     fun getData(
        @Query("page") page: Int,
        @Query("query") query: String,
        @Query("client_id") clientId: String
    ) : Call<MainData>
}