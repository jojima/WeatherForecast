package com.example.fabiojojima.retrofitapp.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.fabiojojima.retrofitapp.weather.WeatherData

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.example.fabiojojima.retrofitapp.weather.CityWeather
import com.example.fabiojojima.retrofitapp.weather.Forecast

@Dao
interface WeatherDao {
    @OnConflictStrategy
    @Insert
    fun insert (weatherData: WeatherData)

    @Query("DELETE FROM weather_table")
    fun clear()

    @Query("SELECT * FROM weather_table")
    fun getAllCitiesWeather() : LiveData<WeatherData>

    @Delete
    fun deleteCity(weatherData: WeatherData)

    @Update
    fun updateCity(weatherData : WeatherData)

}