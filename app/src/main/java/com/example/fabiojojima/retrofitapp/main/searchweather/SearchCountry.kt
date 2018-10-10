package com.example.fabiojojima.retrofitapp.main.searchweather

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import com.example.fabiojojima.retrofitapp.R
import com.example.fabiojojima.retrofitapp.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_weather.*
import kotlinx.android.synthetic.main.search_location.*

class SearchCountry : AppCompatActivity(), NewSearchCallback {
    private lateinit var viewModel: SearchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_location)
        setupViewModel()
        setupTextWatcher()
        search_country.setOnClickListener { getInfoFromAPI() }
    }

    private fun getInfoFromAPI() {
        viewModel.insert(cityNameInput.toString(), countryNameInput.toString())
    }

    private fun setupTextWatcher() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        viewModel.callback = this
    }

    override fun onTitleEmpty() {
        cityLayout.isErrorEnabled = true
        cityLayout.error = getString(R.string.empty_country)
    }

}
