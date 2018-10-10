package com.example.fabiojojima.retrofitapp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import android.databinding.adapters.Converters
import com.example.fabiojojima.retrofitapp.weather.City
import com.example.fabiojojima.retrofitapp.weather.CityWeather
import com.example.fabiojojima.retrofitapp.weather.WeatherData

@Database(
        entities = [CityWeather::class, City::class],
        version = 1
)
abstract class WeatherRoomDB: RoomDatabase() {

    abstract fun weatherDao(): WeatherDao
    abstract fun cityDao(): CityDao

    companion object {
        private var instance: WeatherRoomDB? = null

        private val sRoomDatabaseCallback = object : RoomDatabase.Callback(){}
        fun getDatabase(context: Context): WeatherRoomDB? {
            if (instance == null){
                synchronized(WeatherRoomDB::class.java) {
                    if (instance == null) {
                        instance = Room
                                .databaseBuilder(context.applicationContext, WeatherRoomDB::class.java!!, "task_database")
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