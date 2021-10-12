package com.example.justtestproject.presentation.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.justtestproject.R
import com.example.justtestproject.remote.json_objects.Result
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class RecyclerAdapter(): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    var listResults = mutableListOf<Result>()

    fun setData(list: MutableList<Result>){
        listResults.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView = itemView.image

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val itemView = LayoutInflater.from(parent.context)
        .inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(holder.itemView.context)
            .load(listResults[position].urls.small)
            .into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return listResults.size
    }

}









//        val currentItem = results[position].urls.full
//
//        SecondFragment.picasso = Picasso.with(holder.itemImage.context).load(currentItem)
//

//    private val results = mutableListOf<Result>()
//    fun setData(list: MutableList<Result>){



//        results.addAll(list)
//        notifyDataSetChanged()