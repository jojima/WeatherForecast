package com.example.fabiojojima.retrofitapp.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import com.example.fabiojojima.retrofitapp.database.CityDao
import com.example.fabiojojima.retrofitapp.database.WeatherRoomDB
import com.example.fabiojojima.retrofitapp.weather.City
import org.jetbrains.anko.doAsync
import java.util.concurrent.Future

class CityRepository(application: Application) {
    private val db: WeatherRoomDB = WeatherRoomDB.getDatabase(application)!!
    private val dao: CityDao = db.cityDao()
    private var allCities: LiveData<List<City>> = dao.getAllCities()

    fun insert(city: City) {
        doAsync { dao.insert(city) }
    }

    fun getAllCities(): LiveData<List<City>> {
        return allCities
    }

    fun delete(city: City) {
        doAsync { dao.delete(city) }
    }

    fun getCityByName(cityName : String) : Future<Unit> {
        return doAsync { dao.getCityByName(cityName) }
    }
}