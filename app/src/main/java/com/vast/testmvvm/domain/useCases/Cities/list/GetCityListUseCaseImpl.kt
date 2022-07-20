package com.vast.testmvvm.domain.useCases.Cities.list

import com.vast.testmvvm.domain.models.City

class GetCityListUseCaseImpl : GetCityListUseCase {
    override fun execute(): ArrayList<City> {
        val cities = ArrayList<City>()
        for (i in 1..100 ) {
            cities.add(City(i, "City_name_$i"))
        }

        return cities
    }
}