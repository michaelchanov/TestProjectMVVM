package com.example.justtestproject.presentation.ui.firstFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

}