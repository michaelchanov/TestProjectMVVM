package com.example.justtestproject.presentation.ui.secondFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.justtestproject.R
import com.example.justtestproject.databinding.FragmentSecondBinding
import com.example.justtestproject.presentation.recyclerview.RecyclerAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext


class SecondFragment() : Fragment(R.layout.fragment_second), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: SecondViewModel
    private var adapter: RecyclerAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)
        adapter = RecyclerAdapter()
        viewModel = ViewModelProvider(this)[SecondViewModel::class.java]
        initRecyclerView()

        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter?.setData(it)
            }
        })
        viewModel.retrofitCall()


    }

    private fun initRecyclerView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.setItemViewCacheSize(20)
    }
}
