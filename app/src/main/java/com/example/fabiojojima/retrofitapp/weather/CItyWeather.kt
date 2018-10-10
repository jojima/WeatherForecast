package com.example.fabiojojima.retrofitapp.weather

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "city_weather_table")
class CityWeather {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ForeignKey(entity = City::class , parentColumns = ["id"], childColumns = ["city_name"], onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)
    var city_name: String = ""

    var temp: Float = 0.0F

    var temp_min: Float = 0.0F

    var temp_max: Float = 0.0F

    var humidity: Float = 0.0F

    var main: String = ""

    var description: String = ""

    var icon: String = ""

    var dt_txt: String = ""


    fun getTempNow(): String{
        return "$temp K"
    }

    fun getTempMin(): String{
        return "$temp_min K"
    }

    fun getTempMax(): String{
        return "$temp_max K"
    }

    fun getHumidityNow(): String{
        return "$humidity %"
    }
}