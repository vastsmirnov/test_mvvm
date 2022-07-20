package com.vast.testmvvm.domain.di

import com.vast.testmvvm.domain.useCases.Cities.list.GetCityListUseCase
import com.vast.testmvvm.domain.useCases.Cities.list.GetCityListUseCaseImpl
import com.vast.testmvvm.domain.useCases.Cities.info.GetCityInfoUseCase
import com.vast.testmvvm.domain.useCases.Cities.info.GetCityInfoUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    single <GetCityListUseCase> {
        GetCityListUseCaseImpl()
    }

    single <GetCityInfoUseCase> {
        GetCityInfoUseCaseImpl()
    }
}