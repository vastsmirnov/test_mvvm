package com.vast.testmvvm.ui.cities.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vast.testmvvm.databinding.ActivityCityInfoBinding
import com.vast.testmvvm.ui.extensions.requireExtra
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CityInfoActivity : AppCompatActivity() {
    private val cityId: Int by requireExtra("city_id")

    private val vm: CityInfoVM by viewModel {
        parametersOf(
            cityId
        )
    }

    lateinit var binding: ActivityCityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm.cityInfoLiveData.observe(this) {
            binding.tvId.text = it.id.toString()
            binding.tvCityName.text = it.name
        }
    }
}