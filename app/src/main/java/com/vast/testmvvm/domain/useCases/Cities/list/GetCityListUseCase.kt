package com.vast.testmvvm.domain.useCases.Cities.list

import com.vast.testmvvm.domain.models.City

interface GetCityListUseCase {
    fun execute(): ArrayList<City>
}