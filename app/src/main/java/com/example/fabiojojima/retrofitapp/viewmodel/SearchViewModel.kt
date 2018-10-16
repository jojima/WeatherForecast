package com.example.fabiojojima.retrofitapp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.fabiojojima.retrofitapp.main.searchweather.NewSearchCallback
//import com.example.fabiojojima.retrofitapp.repository.CityRepository
import com.example.fabiojojima.retrofitapp.repository.WeatherRepository
import com.example.fabiojojima.retrofitapp.weather.WeatherData

class SearchViewModel(application: Application) : AndroidViewModel(application)  /*,BaseObservable()*/ {
    private val repositoryWeather = WeatherRepository(application)
//    private val repositoryCity = CityRepository(application)
    var callback: NewSearchCallback? = null


    //bindable if use BaseObservable
    /*@get:Bindable
    var weather by BindableDelegate("", BR.forecast)*/

    fun insert(city: String, country: String) {
        repositoryWeather.getWeather(city, country)
    }

    fun canSaveNewToDoItem(text: String): Boolean {
        return if (text.isBlank()) {
            callback?.onTitleEmpty()
            false
        } else true
    }
}