package com.vast.testmvvm.domain.useCases.Cities.info

import com.vast.testmvvm.domain.models.City

interface GetCityInfoUseCase {
    fun execute(id: Int): City
}