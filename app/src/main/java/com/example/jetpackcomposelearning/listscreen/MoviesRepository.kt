package com.example.jetpackcomposelearning.listscreen

import android.util.Log
import com.example.jetpackcomposelearning.networking.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Singleton
class MoviesRepository(
    private val movieApiService: Api
) {

    private val compositeDisposable = CompositeDisposable()

    fun loadMovies(
        viewModel: ListViewModel
    ) {
        compositeDisposable.add(
            movieApiService.fetchMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { response ->
                        viewModel.fetchedData(response?.results, null)
                    },
                    { error ->
                        viewModel.fetchedData(null, error)
                        Log.e("ERROR", error.localizedMessage)
                    }
                )
        )
    }
}