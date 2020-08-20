package com.example.televisionapp.screen.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.televisionapp.R
import com.example.televisionapp.TelevisionApp
import com.example.televisionapp.model.Attachments
import com.example.televisionapp.model.Movie
import com.example.televisionapp.utils.ScreenState
import com.example.televisionapp.utils.gone
import com.example.televisionapp.utils.visible
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.error_view.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.movie_item.view.*
import javax.inject.Inject



class DetailFragment : Fragment() {

    @Inject
    lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bundle = arguments
        val movieId = bundle?.getString("movieId")
        detailViewModel.initialize(movieId)
        setupObservers()
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

        init { TelevisionApp.daggerAppComponent().inject(this) }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
        }

        private fun setupReloadButton() {
            reloadButton.setOnClickListener { detailViewModel.loadData() }
        }

        private fun setupObservers() {
            observeData()
            observeState()
        }

        private fun observeState() {
            detailViewModel.uiState.observe(this, Observer {
                setupReloadButton()
                updateUI(it)
            })
        }

        private fun observeData() {
            detailViewModel.uiModel.observe(this, Observer {
                setupUI(it)
            })
        }

        private fun setupUI(movie: Movie) {
            nameTextView.text = movie.name
            yearTextView.text = movie.year.toString()
            descriptionTextView.text = movie.description

            Picasso.with(context)
                .load(Attachments.BASE_URL.plus(movie.attachments?.find { it.name.contains("COVER") }?.value))
                .into(posterImageView)
        }

        private fun updateUI(it: ScreenState?) {
            when (it) {
                ScreenState.Error -> {
                    detailProgressBar.gone()
                    detailView.gone()
                    detailErrorView.visible()
                }
                ScreenState.Loading -> detailProgressBar.visible()
                ScreenState.Success -> {
                    detailProgressBar.gone()
                    detailView.visible()
                }
            }
        }
}