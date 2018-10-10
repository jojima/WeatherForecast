package com.example.fabiojojima.retrofitapp.weather

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "weather_table")
data class WeatherData(val cod: Int,
                       val city: City,
                       val message: Float,
                       val cnt: Int,
                       val list: List<Forecast>)
