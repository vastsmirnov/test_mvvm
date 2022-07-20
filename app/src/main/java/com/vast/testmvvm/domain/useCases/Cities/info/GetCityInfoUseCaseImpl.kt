package com.vast.testmvvm.domain.useCases.Cities.info

import com.vast.testmvvm.domain.models.City

class GetCityInfoUseCaseImpl : GetCityInfoUseCase {
    override fun execute(id: Int): City {
        return City(id, "name_$id")
    }
}