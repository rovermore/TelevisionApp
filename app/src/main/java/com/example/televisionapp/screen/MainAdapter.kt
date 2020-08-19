package com.example.televisionapp.screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.televisionapp.R
import com.example.televisionapp.model.Attachments.Companion.BASE_URL
import com.example.televisionapp.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*

class MainAdapter (
    var movieList: MutableList<Movie>?
) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(movieList.isNullOrEmpty()){
            return 0
        }
        return movieList!!.size
    }

    override fun onBindViewHolder(holder: MainAdapter.MyViewHolder, position: Int) {
        if(!movieList.isNullOrEmpty()) {
            holder.bindView(movieList!![position])
        }
    }

    fun updateTransactionList(transactionList: MutableList<Movie>?){
        this.movieList = transactionList
        notifyDataSetChanged()
    }

    fun clearMainAdapter() {
        movieList?.run {
            movieList!!.clear()
            movieList = null
            notifyDataSetChanged()
        }
    }

    inner class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view)  {
        fun bindView(movie: Movie) {
            view.apply {
                Picasso.with(context)
                    .load(BASE_URL.plus(movie.attachments?.find { it.name.contains("COVER") }?.value))
                    .into(movieImageView);
            }
        }
    }
}