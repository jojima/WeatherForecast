package com.example.fabiojojima.retrofitapp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import android.widget.Toast
import com.example.fabiojojima.retrofitapp.BR
import com.example.fabiojojima.retrofitapp.Retrofit.RetrofitCaller
import com.example.fabiojojima.retrofitapp.Retrofit.WeatherClient
import com.example.fabiojojima.retrofitapp.main.BindableDelegate
import com.example.fabiojojima.retrofitapp.main.searchweather.NewSearchCallback
import com.example.fabiojojima.retrofitapp.repository.CityRepository
import com.example.fabiojojima.retrofitapp.repository.WeatherRepository
import com.example.fabiojojima.retrofitapp.weather.City
import com.example.fabiojojima.retrofitapp.weather.CityWeather
import com.example.fabiojojima.retrofitapp.weather.WeatherData
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import okhttp3.ResponseBody
import org.joda.time.DateTime

class SearchViewModel(application: Application, context: Context) : AndroidViewModel(application) , /*BaseObservable()*/ {
    private val repositoryWeather = WeatherRepository(application)
    private val repositoryCity = CityRepository(application)
    var callback: NewSearchCallback? = null
    var caller = RetrofitCaller()
    var client = caller.createClient(WeatherClient::class.java)

    //bindable if use BaseObservable
    /*@get:Bindable
    var weather by BindableDelegate("", BR.forecast)*/

    fun insert(city: String, country: String) {
        var call = caller.callSync(client, city, country)
        call.enqueue(object : retrofit2.Callback<WeatherData> {
            override fun onResponse(call: retrofit2.Call<WeatherData>, response: retrofit2.Response<WeatherData>) {
                var forecast = response.body()
                var code = response.code()
                if (code == 404) {
//                    Toast.makeText(context, "City does not exist!", Toast.LENGTH_LONG).show()
                    //no existent city
                } else if (code == 200) {
                    if (forecast != null && forecast.list.isNotEmpty()) {
                        val city : City = forecast.city
                        city.lastUpdatedDate = DateTime.now()
                        repositoryCity.insert(city)
                    } else {
//                        Toast.makeText(mContext, "Server did not post weathers list, try again.", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<WeatherData>, t: Throwable) {
                Log.d("API",t.message)
            }
        })
    }

    fun canSaveNewToDoItem(text: String): Boolean {
        return if (text.isBlank()) {
            callback?.onTitleEmpty()
            false
        } else true
    }
}