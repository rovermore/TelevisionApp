package com.example.televisionapp.screen.main

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
    var movieList: MutableList<Movie>?,
    var itemClicked: OnItemClicked
    ) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    interface OnItemClicked {
        fun itemClicked(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(movieList.isNullOrEmpty()){
            return 0
        }
        return movieList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
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

    inner class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener   {

        init{
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val currentMovie = movieList?.get(position)
            itemClicked.itemClicked(currentMovie!!)
        }

        fun bindView(movie: Movie) {
            view.apply {
                Picasso.with(context)
                    .load(BASE_URL.plus(movie.attachments?.find { it.name.contains("COVER") }?.value))
                    .into(movieImageView)
            }
        }
    }
}