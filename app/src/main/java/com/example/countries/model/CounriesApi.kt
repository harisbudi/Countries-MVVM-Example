package com.example.countries.model

import io.reactivex.Single
import retrofit2.http.GET

interface CounriesApi {

    @GET("countries/master.json")
    fun getCountries(): Single<List<Country>>
}