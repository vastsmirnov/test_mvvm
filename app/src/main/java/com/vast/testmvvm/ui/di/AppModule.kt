package com.vast.testmvvm.ui.di

import com.vast.testmvvm.ui.cities.info.CityInfoViewModel
import com.vast.testmvvm.ui.cities.list.CityListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<CityListViewModel> {
        CityListViewModel(
            getCityListUseCase = get()
        )
    }
    viewModel { (cityId: Int) ->
        CityInfoViewModel(
            cityId = cityId,
            getCityInfoUseCase = get()
        )
    }
}