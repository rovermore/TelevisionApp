package com.example.televisionapp.screen.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.televisionapp.model.Movie
import com.example.televisionapp.usecase.MovieDetailUseCase
import com.example.televisionapp.utils.NetworkConnection
import com.example.televisionapp.utils.ScreenState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DetailViewModel
    @Inject constructor(private val networkConnection: NetworkConnection,
                        private val movieDetailUseCase: MovieDetailUseCase
    ) : ViewModel() {

    private val coroutineContext: CoroutineContext get() = Job() + Dispatchers.Main
    private val viewModelScope = CoroutineScope(coroutineContext)

    private val _uiModel =
        MutableLiveData<Movie>()
    val uiModel: LiveData<Movie> = _uiModel

    private val _uiState = MutableLiveData<ScreenState>()
    val uiState: LiveData<ScreenState> = _uiState

    private var movieId: String = ""

    fun initialize(movieId: String?) {
        movieId?.let { this.movieId = it }
        loadData()
    }

    fun loadData() {
        _uiState.setValue(ScreenState.Loading)
        checkInternetConnection()
    }

    private fun checkInternetConnection() {
        if (networkConnection.isNetworkConnected())
            setupObservers()
        else
            _uiState.setValue(ScreenState.Error)
    }

    private fun setupObservers() {
        observeResponse()
    }

    private fun observeResponse() {
        viewModelScope.launch {
            val response = movieDetailUseCase.requestWithParameter(movieId)
            if (response.movieDetail == null)
                displayError()
            else
                createAndPostUiModel(response.movieDetail!!)
        }
    }

    private fun displayError() {
        _uiState.setValue(ScreenState.Error)
    }

    private fun createAndPostUiModel(response: Movie) {
        viewModelScope.launch {
            _uiModel.setValue(response)
            _uiState.setValue(ScreenState.Success)
        }
    }

}