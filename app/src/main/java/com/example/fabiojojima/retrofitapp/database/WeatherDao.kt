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

@Dao
interface WeatherDao {
    @Insert
    fun insert (weatherData: CityWeather)

    @Query("DELETE FROM city_weather_table")
    fun clear()

    @Query("SELECT * FROM city_weather_table ORDER BY id ASC")
    fun getAllCitiesWeather() : LiveData<List<CityWeather>>

    @Delete
    fun deleteCity(weatherData: CityWeather)

    @Update
    fun updateCity(weatherData : CityWeather)

}