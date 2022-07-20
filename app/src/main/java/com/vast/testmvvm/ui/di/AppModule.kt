package com.vast.testmvvm.ui.di

import com.vast.testmvvm.ui.cities.info.CityInfoVM
import com.vast.testmvvm.ui.cities.list.CityListVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<CityListVM> {
        CityListVM(
            getCityListUseCase = get()
        )
    }
    viewModel { (cityId: Int) ->
        CityInfoVM(
            cityId = cityId,
            getCityInfoUseCase = get()
        )
    }
}