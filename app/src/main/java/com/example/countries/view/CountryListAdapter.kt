package com.example.countries.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.countries.R
import com.example.countries.model.Country
import com.example.countries.utils.getProgressDrawable
import com.example.countries.utils.loadImage
import kotlinx.android.synthetic.main.item_country.view.*

class CountryListAdapter(var countries : ArrayList<Country>):
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent : ViewGroup, p1: Int)  = CountryViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false)
    )

    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    fun updateCountry(newCountries :List<Country>){
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }
    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view){
        val countryName = view.name
        val countryFlag = view.imageView
        val countryCapital = view.capital
        private val progressDrawable = getProgressDrawable(view.context)
        fun bind(country: Country){
            countryName.text = country.countryName
            countryCapital.text = country.capital
            countryFlag.loadImage(country.flag, progressDrawable)
        }
    }
}