package com.example.fabiojojima.retrofitapp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import com.example.fabiojojima.retrofitapp.weather.WeatherData
import com.example.fabiojojima.retrofitapp.repository.WeatherRepository
import com.example.fabiojojima.retrofitapp.weather.CityWeather
import com.example.fabiojojima.retrofitapp.weather.Forecast

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = WeatherRepository(application)

    fun insert(weatherData: WeatherData) {
        repository.insert(weatherData)
    }

    fun deleteCity(weatherData : WeatherData) {
        repository.delete(weatherData)
    }

    fun deleteAll(){
        repository.clearDB()
    }

    fun update(weatherData : WeatherData) {
        repository.update(weatherData)
    }

    fun getAllWeathersVM(): LiveData<WeatherData>{
        val lastCity = repository.lastCity
        return repository.getForecastFrom()
    }
}