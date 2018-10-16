package com.example.fabiojojima.retrofitapp.Retrofit

import android.arch.persistence.room.TypeConverter
import com.example.fabiojojima.retrofitapp.weather.City
import com.example.fabiojojima.retrofitapp.weather.Forecast
import com.example.fabiojojima.retrofitapp.weather.Weather
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



class ListConverter  {
    lateinit var gson:Gson

    @TypeConverter
    fun toGsonFromCity(city: City): String{
        return gson.toJson(city)
    }

    @TypeConverter
    fun fromGsonTo(string: String): City{
        val type = object : TypeToken<City>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun toGsonFromList(forecast: List<Forecast>): String{
        return gson.toJson(forecast)
    }

    @TypeConverter
    fun fromGson(string: String): List<Forecast>{
        val type = object : TypeToken<List<Forecast>>() {}.type
        return gson.fromJson(string, type)
    }
}

/*
    @TypeConverter
    fun fromForecast(list: List<Forecast>): String? {
        val type = object : TypeToken<List<Forecast>>() {}.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toForecast(data: String?): Forecast? {
        val type = object : TypeToken<List<Forecast>>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun toWeather(value: String): List<Weather> {
        val listType = object : TypeToken<List<Weather>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toGsonWeather(list: List<Weather>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromCity(value: String): List<City> {
        val listType = object : TypeToken<List<City>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toGsonCity(list: List<City>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
* */