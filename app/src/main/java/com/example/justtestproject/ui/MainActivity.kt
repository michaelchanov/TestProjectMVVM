package com.example.justtestproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.justtestproject.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FirstFragment())
            .commit()
    }
}