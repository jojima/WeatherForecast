package com.example.fabiojojima.retrofitapp.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.fabiojojima.retrofitapp.weather.City

@Dao
interface CityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(city: City)

    @Query("SELECT * FROM city_table")
    fun getAllCities(): LiveData<List<City>>

    @Delete
    fun delete(city: City)

    @Query("SELECT * FROM city_table WHERE name = :cityName")
    fun getCityByName(cityName : String) : City
}