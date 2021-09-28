package com.example.justtestproject.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.justtestproject.R
import com.example.justtestproject.databinding.FragmentSecondBinding
import com.example.justtestproject.remote.json_objects.Result
import com.example.justtestproject.remote.retrofit.DataRepository
import com.example.justtestproject.ui.recyclerview.RecyclerAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class SecondFragment() : Fragment(R.layout.fragment_second), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private lateinit var binding: FragmentSecondBinding
    private var resultsList: MutableList<Result>? = null
    private var adapter: RecyclerAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)
        adapter = RecyclerAdapter()


        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.setItemViewCacheSize(20)

        val repository = DataRepository()

        launch {
            resultsList = repository.getData().await() as MutableList<Result>?
            resultsList?.let { adapter?.setData(it) }
        }




    }

}




//private fun getCurrentData(){
//        val api = Retrofit.Builder()
//            .baseUrl("https://api.unsplash.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(DataApi::class.java)
//
//        GlobalScope.launch(Dispatchers.IO) {
//            val response = api.getData(page = 1, query = word, clientId = "sFU9rKMEnsqICAd3irqQph4Oxa0zuTtbpplmXLX5hgY").awaitResponse()
//            if(response.isSuccessful) {
//                val data = response.body()!!
//
//                withContext(Dispatchers.Main){
//                    adapter?.setData(data.results as MutableList<Result>)
//                }
//
//            }
//        }
//    }