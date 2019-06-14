package com.example.countries.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.countries.model.Country

class ListViewModel :ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){

    }
    fun fetchCountries(){
        val mockdata = listOf(
            Country("a"),
            Country("a"),
            Country("a"),
            Country("a"))
        countryLoadError.value = false
        loading.value =  false
        countries.value = mockdata
    }
}