package com.example.fabiojojima.retrofitapp.weather

data class Weather(var id: Int,
                var main: String,
                var description: String,
                var icon: String)