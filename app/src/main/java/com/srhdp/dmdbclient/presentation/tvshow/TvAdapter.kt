package com.srhdp.dmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.srhdp.dmdbclient.R
import com.srhdp.dmdbclient.data.model.tvshow.TvShow
import com.srhdp.dmdbclient.databinding.ListItemBinding

class TvAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val tvList = ArrayList<TvShow>()
    fun setList(tvs:List<TvShow>){
        tvList.clear()
        tvList.addAll(tvs)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)
        val binding:ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(tvList[position])
    }

    override fun getItemCount(): Int {
       return tvList.size
    }
}
class MyViewHolder(val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow: TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterUrl:String ="https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}