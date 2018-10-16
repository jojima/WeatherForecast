package com.example.fabiojojima.retrofitapp.Retrofit

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.fabiojojima.retrofitapp.weather.City
import com.example.fabiojojima.retrofitapp.weather.CityWeather
import com.example.fabiojojima.retrofitapp.weather.WeatherData
import okhttp3.ResponseBody
import okhttp3.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import java.io.File


class RetrofitCaller(context: Context) {
    private var API_BASE_URL = "http://api.openweathermap.org/data/2.5/"
    var cacheSize: Long = 10 * 1024 * 1024
    var cache = Cache(context.getCacheDir(), cacheSize)

    var okHttpClient = OkHttpClient.Builder()
            .cache(cache)
            .build()

    private val builder = Retrofit.Builder()
                   .baseUrl(API_BASE_URL)
                   .client(okHttpClient)
                   .addConverterFactory(GsonConverterFactory.create())
    val retrofit = builder.build()


    fun callSync(client: WeatherClient?, city: String, country: String? = null): Call<WeatherData> {
        if (country != ""){
            return client!!.weatherSync("$city,$country", "c4af3f440c3cb5de77e4b494a47e09ac")
        }
        else{
            return client!!.weatherSync("$city", "c4af3f440c3cb5de77e4b494a47e09ac")
        }
    }

    fun createClient(clientClass: Class<WeatherClient>): WeatherClient? {
        return retrofit.create(clientClass)
    }
}