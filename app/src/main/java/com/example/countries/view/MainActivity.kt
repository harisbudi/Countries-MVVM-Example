package com.example.countries.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.countries.R
import com.example.countries.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val countriesAdapter = CountryListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            viewModel.refresh()
        }
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.countries.observe(this, Observer { countries ->
            countries?.let {
                recyclerView.visibility = View.VISIBLE
                countriesAdapter.updateCountry(it)
            }
        })
        viewModel.countryLoadError.observe(this, Observer { isError ->
            isError?.let {
                error_text.visibility = if(it) View.VISIBLE else View.GONE
            }
        })
        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                progressBar.visibility = if (it) View.VISIBLE else View.GONE
                if (it){
                    error_text.visibility = View.GONE
                    recyclerView.visibility = View.GONE
                }
            }
        })
    }
}
