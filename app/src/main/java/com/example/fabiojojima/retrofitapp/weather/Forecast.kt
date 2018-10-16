package com.example.fabiojojima.retrofitapp.weather

data class Forecast (var weather: List<Weather>,
                     var main: main,
                     var dt_txt: String){
    fun getTempMax(): String{
        return this.main.temp_max.toString()
    }
    fun getTempMin(): String{
        return this.main.temp_min.toString()
    }

    fun getTempNow(): String{
        return this.main.temp.toString()
    }

    fun getHumidityNow(): String{
        return this.main.humidity.toString()
    }

    fun getDate():String{
        return this.dt_txt
    }
}
