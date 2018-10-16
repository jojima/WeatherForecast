package com.example.fabiojojima.retrofitapp.weather

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherData(val cod: Int,
                       val city: City,
                       @PrimaryKey var id: Int = city.id,
                       var cityName: String = city.name,
                       val message: Float,
                       val cnt: Int,
                       val list: List<Forecast>)
