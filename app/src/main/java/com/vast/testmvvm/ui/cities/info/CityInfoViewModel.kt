package com.vast.testmvvm.ui.cities.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vast.testmvvm.domain.models.City
import com.vast.testmvvm.domain.useCases.Cities.info.GetCityInfoUseCase

class CityInfoViewModel(
    private val cityId: Int,
    private val getCityInfoUseCase: GetCityInfoUseCase
) : ViewModel() {
    private val _cityInfoLiveData = MutableLiveData<City>()
    val cityInfoLiveData = _cityInfoLiveData as LiveData<City>

    init {
        getCityInfoById()
    }

    private fun getCityInfoById() {
        _cityInfoLiveData.value = getCityInfoUseCase.execute(cityId)
    }
}