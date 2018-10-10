package com.example.fabiojojima.retrofitapp.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fabiojojima.retrofitapp.weather.WeatherData
import com.example.fabiojojima.retrofitapp.databinding.ItemWeatherBinding
import com.example.fabiojojima.retrofitapp.weather.CityWeather

class MainAdapter(private val listener: OnItemListener) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var mWeatherData: List<WeatherData>? = null
    private var itemPos = RecyclerView.NO_POSITION
    interface OnItemListener {
        fun onLongClick()
    }

    private val list = mutableListOf<CityWeather>()

/*    init {
        setHasStableIds(true)
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWeatherBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weather = list[position]
        holder.bind(weather)
    }

    fun setData(data: List<CityWeather>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(weather: CityWeather?) {
            binding.forecast = weather
            binding.executePendingBindings()
        }
    }
}