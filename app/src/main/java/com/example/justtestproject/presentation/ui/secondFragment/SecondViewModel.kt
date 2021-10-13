package com.example.justtestproject.presentation.ui.secondFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justtestproject.data.remote.json_objects.Result
import com.example.justtestproject.data.remote.retrofit.DataRepository
import com.example.justtestproject.presentation.ui.firstFragment.FirstFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SecondViewModel : ViewModel() {
    lateinit var recyclerListLiveData: MutableLiveData<MutableList<Result>>

    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver(): MutableLiveData<MutableList<Result>> {
        return recyclerListLiveData
    }


    fun retrofitCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retrofitInstance = DataRepository.retrofitInstance()
            val response = retrofitInstance.getData(page = 1, clientId = "sFU9rKMEnsqICAd3irqQph4Oxa0zuTtbpplmXLX5hgY",
                query = FirstFragment.word).execute()
                .body()
                ?.results
            recyclerListLiveData.postValue(response as MutableList<Result>?)
        }
    }
}