package com.example.justtestproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.justtestproject.R
import com.example.justtestproject.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var binding: FragmentFirstBinding
    companion object {
        var word = ""
        }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)


        binding.buttonNext.setOnClickListener {
            word = binding.searchBar.text.toString()
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, SecondFragment())
                ?.commit()
        }
    }

}