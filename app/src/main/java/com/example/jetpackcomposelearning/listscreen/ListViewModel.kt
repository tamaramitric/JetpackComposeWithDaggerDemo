package com.example.jetpackcomposelearning.listscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcomposelearning.data.Movie
import com.example.jetpackcomposelearning.networking.Api
import javax.inject.Inject

class ListViewModel @Inject constructor(
    moviesApi: Api
) : ViewModel(){

    private val movieRepository: MoviesRepository = MoviesRepository(moviesApi)
    val data = MutableLiveData<List<Movie>>()

    init {
        movieRepository.loadMovies(this)
    }

    fun fetchedData(movies: List<Movie>?, error: Throwable?) {
        when {
            error != null -> {
                _pageState.value = PageState.ERROR
            }
            movies.isNullOrEmpty() -> {
                _pageState.value = PageState.EMPTY
            }
            else -> {
                data.postValue(movies)
                _pageState.value = PageState.DATA
            }
        }
    }

    private val _pageState = mutableStateOf(PageState.LOADING)
    val pageState: State<PageState>
        get() = _pageState

    enum class PageState {
        LOADING,
        DATA,
        ERROR,
        EMPTY
    }
}