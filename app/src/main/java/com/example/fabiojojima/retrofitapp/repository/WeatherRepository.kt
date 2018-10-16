package com.example.fabiojojima.retrofitapp.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.util.Log
import com.example.fabiojojima.retrofitapp.Retrofit.RetrofitCaller

import com.example.fabiojojima.retrofitapp.Retrofit.WeatherClient
import com.example.fabiojojima.retrofitapp.database.WeatherRoomDB
import com.example.fabiojojima.retrofitapp.weather.City
import com.example.fabiojojima.retrofitapp.weather.CityWeather
import com.example.fabiojojima.retrofitapp.weather.Forecast
import com.example.fabiojojima.retrofitapp.weather.WeatherData
import org.jetbrains.anko.doAsync
import retrofit2.Call
class WeatherRepository(application: Application) {

    /*    var caller = RetrofitCaller()
    //    var temp = caller.callSync(client!!, "$city", "$country")
        var client = caller.createClient(WeatherClient::class.java)*/
    var db = WeatherRoomDB.getDatabase(application)
    var dao = db!!.weatherDao()
    var lastCity: String = ""
    val mApplication = application

    lateinit var call : Call<WeatherClient>

    fun getForecastFrom(): LiveData<WeatherData>{
//        doAsync{ dao.getAllCitiesWeather() }
        return dao.getAllCitiesWeather()
    }
    fun insert(weatherData: WeatherData){
        lastCity = weatherData.city.name
        doAsync { dao.insert(weatherData) }
    }
    fun delete(weatherData: WeatherData){
        doAsync { dao.deleteCity(weatherData) }
    }
    fun update(weatherData: WeatherData){
        doAsync { dao.updateCity(weatherData) }
    }

    fun clearDB(){
        doAsync { dao.clear() }
    }

    fun getWeather(city: String, country: String):LiveData<WeatherData>{
        val data=MutableLiveData<WeatherData>()
        var caller = RetrofitCaller(mApplication.applicationContext)
        var client = caller.createClient(WeatherClient::class.java)
        var call = caller.callSync(client, city, country)
        call.enqueue(object : retrofit2.Callback<WeatherData> {
            override fun onResponse(call: retrofit2.Call<WeatherData>, response: retrofit2.Response<WeatherData>) {
                var forecast = response.body()
                var code = response.code()
                data.value=response.body()
//                if (code == 404) {
////                    Toast.makeText(context, "City does not exist!", Toast.LENGTH_LONG).show()
//                    //no existent city
//                } else if (code == 200) {
//                        lastCity = forecast!!.city.name
//                        forecast.id = forecast.city.id
//                        forecast.cityName = forecast.city.name
//                        doAsync {
//                            dao.clear()
//                            dao.insert(forecast) }
//
//                }
            }

            override fun onFailure(call: retrofit2.Call<WeatherData>, t: Throwable) {
                Log.d("API",t.message)
            }
        })
        return data
    }
}