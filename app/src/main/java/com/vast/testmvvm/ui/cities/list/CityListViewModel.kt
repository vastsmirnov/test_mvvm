package com.vast.testmvvm.ui.cities.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vast.testmvvm.domain.models.City
import com.vast.testmvvm.domain.useCases.Cities.list.GetCityListUseCase

class CityListViewModel(private val getCityListUseCase: GetCityListUseCase) : ViewModel() {
    private val _citiesLiveDta = MutableLiveData<List<City>>()
    val citiesLiveDta = _citiesLiveDta as LiveData<List<City>>

    init {
        loadCityList()
    }

    private fun loadCityList() {
        _citiesLiveDta.value = getCityListUseCase.execute()
    }
}