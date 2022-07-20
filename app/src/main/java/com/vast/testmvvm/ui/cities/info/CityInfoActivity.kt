package com.vast.testmvvm.ui.cities.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vast.testmvvm.databinding.ActivityCityInfoBinding
import com.vast.testmvvm.ui.extensions.requireExtra
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CityInfoActivity : AppCompatActivity() {
    companion object {
        const val CITY_ID = "city_id"
    }

    private val cityId: Int by requireExtra(CITY_ID)

    private val viewModel: CityInfoViewModel by viewModel {
        parametersOf(
            cityId
        )
    }

    lateinit var binding: ActivityCityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.cityInfoLiveData.observe(this) {
            with(binding) {
                tvId.text = it.id.toString()
                tvCityName.text = it.name
            }
        }
    }
}