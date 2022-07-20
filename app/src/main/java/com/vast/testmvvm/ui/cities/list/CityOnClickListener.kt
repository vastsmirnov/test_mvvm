package com.vast.testmvvm.ui.cities.list

import com.vast.testmvvm.domain.models.City

interface CityOnClickListener {
    fun onClicked(city: City)
}