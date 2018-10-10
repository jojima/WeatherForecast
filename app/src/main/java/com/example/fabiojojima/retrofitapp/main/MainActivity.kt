package com.example.fabiojojima.retrofitapp.main


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.fabiojojima.retrofitapp.R
import com.example.fabiojojima.retrofitapp.databinding.ActivityMainBinding
import com.example.fabiojojima.retrofitapp.main.searchweather.SearchCountry
import com.example.fabiojojima.retrofitapp.viewmodel.MainViewModel
import com.example.fabiojojima.retrofitapp.weather.WeatherData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainAdapter.OnItemListener {
    override fun onLongClick() {

        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewAdapter: MainAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setupRecyclerView()
        fab.setOnClickListener { openSearchCountry() }
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.getAllWeathersVM().observe(this, Observer {
            fun onChange (weather: List<WeatherData>){
                //TODO update recyclerview
                Toast.makeText(this@MainActivity, "This works!", Toast.LENGTH_LONG)
            }
        })
    }
    private fun setupRecyclerView() {
        viewAdapter = MainAdapter(this)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            adapter = viewAdapter
        }
    }
    private fun openSearchCountry() {
        startActivity(Intent(this, SearchCountry::class.java))
    }
}
