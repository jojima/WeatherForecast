package com.example.fabiojojima.retrofitapp.Retrofit

import com.example.fabiojojima.retrofitapp.weather.City
import com.example.fabiojojima.retrofitapp.weather.CityWeather
import com.example.fabiojojima.retrofitapp.weather.WeatherData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface WeatherClient {
    @GET("/users/{user}/repos")
    fun reposForUser(@Path("user") user: String ): Call<List<GitHubRepo>>
//?q={city},{country}&appid=c4af3f440c3cb5de77e4b494a47e09ac
    @GET("forecast")
    fun weatherSync(@Query("q")city: String, @Query("appid") appid: String): Call<WeatherData>
}