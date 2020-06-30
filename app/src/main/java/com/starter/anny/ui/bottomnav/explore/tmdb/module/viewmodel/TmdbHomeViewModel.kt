package com.starter.anny.ui.bottomnav.explore.tmdb.module.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.starter.anny.domain.tmdbmodule.usecase.TmdbPopularMovieUseCase
import com.starter.anny.ui.bottomnav.explore.tmdb.module.Model.TmdbPopularMoviesModel
import com.starter.anny.ui.bottomnav.explore.tmdb.module.mapper.map
import com.starter.anny.ui.utils.SingleLiveEvent
import com.starter.basestructure.ui.base.BaseObservableViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TmdbHomeViewModel @Inject constructor(
    val app: Application,
    val tmdbPopularMovieUseCase: TmdbPopularMovieUseCase
) : BaseObservableViewModel(app) {

    private val _errorLiveData = SingleLiveEvent<Throwable?>()
    val errorLiveData: LiveData<Throwable?> = _errorLiveData

    private val _progressLiveData = MutableLiveData<Boolean?>()
    val progressLiveData: LiveData<Boolean?> = _progressLiveData

    private val _getTmdbPopularMovies = MutableLiveData<TmdbPopularMoviesModel>()
    val getTmdbPopularMovies: LiveData<TmdbPopularMoviesModel>? =
        _getTmdbPopularMovies


    fun getPopularMovies(api_key: String) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                tmdbPopularMovieUseCase(TmdbPopularMovieUseCase.Params("f4431f3dd6ef45670c96801a8a47080a"))
            }.onSuccess {
                _getTmdbPopularMovies.postValue(it.map())
            }
        }
    }
}