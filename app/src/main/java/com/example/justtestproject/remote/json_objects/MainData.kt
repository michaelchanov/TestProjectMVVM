package com.example.justtestproject.remote.json_objects

data class MainData(
    val results: List<Result>,
    val total: Int,
    val total_pages: Int
)