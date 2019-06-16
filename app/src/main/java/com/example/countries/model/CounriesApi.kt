package com.example.countries.model

import io.reactivex.Single
import retrofit2.http.GET

interface CounriesApi {
    //    ?token=ACDLKPA7YBYQWYDVTUPCSBK5AQXV6
    @GET("harisbudi/Countries-MVVM-Example/master/countries/countries.json")
    fun getCountries(): Single<List<Country>>
}