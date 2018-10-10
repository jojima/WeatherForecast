package com.example.fabiojojima.retrofitapp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.fabiojojima.retrofitapp.weather.WeatherData
import com.example.fabiojojima.retrofitapp.repository.WeatherRepository
import com.example.fabiojojima.retrofitapp.weather.CityWeather

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = WeatherRepository(application)
    private var allWeather = repository.allWeather

    fun insert(weatherData: CityWeather) {
        repository.insert(weatherData)
    }

    fun deleteCity(weatherData : CityWeather) {
        repository.delete(weatherData)
    }

    fun deleteAll(){
        repository.clearDB()
    }

    fun update(weatherData : CityWeather) {
        repository.update(weatherData)
    }

    fun getAllWeathersVM(): LiveData<List<CityWeather>>{
        return allWeather
    }
}