package com.example.fabiojojima.retrofitapp.repository

import android.app.Application
import android.arch.lifecycle.LiveData

import com.example.fabiojojima.retrofitapp.Retrofit.WeatherClient
import com.example.fabiojojima.retrofitapp.database.WeatherRoomDB
import com.example.fabiojojima.retrofitapp.weather.CityWeather
import com.example.fabiojojima.retrofitapp.weather.WeatherData
import org.jetbrains.anko.doAsync
import retrofit2.Call
class WeatherRepository(application: Application) {

    /*    var caller = RetrofitCaller()
    //    var temp = caller.callSync(client!!, "$city", "$country")
        var client = caller.createClient(WeatherClient::class.java)*/
    var db = WeatherRoomDB.getDatabase(application)
    var dao = db!!.weatherDao()
    var allWeather = dao.getAllCitiesWeather()

    lateinit var call : Call<WeatherClient>

    fun getForecastFrom(): LiveData<List<CityWeather>>{
//        doAsync{ dao.getAllCitiesWeather() }
        return allWeather
    }
    fun insert(weatherData: CityWeather){
        doAsync { dao.insert(weatherData) }
    }
    fun delete(weatherData: CityWeather){
        doAsync { dao.deleteCity(weatherData) }
    }
    fun update(weatherData: CityWeather){
        doAsync { dao.updateCity(weatherData) }
    }

    fun clearDB(){
        doAsync { dao.clear() }
    }
}