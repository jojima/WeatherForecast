package com.example.fabiojojima.retrofitapp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.example.fabiojojima.retrofitapp.Retrofit.ListConverter
//import android.databinding.adapters.ListConverter
import com.example.fabiojojima.retrofitapp.weather.City
import com.example.fabiojojima.retrofitapp.weather.CityWeather
import com.example.fabiojojima.retrofitapp.weather.WeatherData

@Database(
        entities = [WeatherData::class],
        version = 1
)
@TypeConverters(ListConverter::class)
abstract class WeatherRoomDB: RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    companion object {
        private var instance: WeatherRoomDB? = null

        private val sRoomDatabaseCallback = object : RoomDatabase.Callback(){}
        fun getDatabase(context: Context): WeatherRoomDB? {
            if (instance == null){
                synchronized(WeatherRoomDB::class.java) {
                    if (instance == null) {
                        instance = Room
                                .databaseBuilder(context.applicationContext, WeatherRoomDB::class.java, "weather_database")
                                .fallbackToDestructiveMigration()
                                .addCallback(sRoomDatabaseCallback)
                                .build()
                    }
                }
            }
            return instance!!
        }
    }
}