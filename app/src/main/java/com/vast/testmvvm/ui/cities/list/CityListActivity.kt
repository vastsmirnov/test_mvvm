package com.vast.testmvvm.ui.cities.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vast.testmvvm.databinding.ActivityCityBinding
import com.vast.testmvvm.domain.models.City
import com.vast.testmvvm.ui.cities.info.CityInfoActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityListActivity : AppCompatActivity() {
    lateinit var binding: ActivityCityBinding
    private val vm by viewModel<CityListVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CityListAdapter(object : CityOnClickListener {
            override fun onClicked(city: City) {
                val intent = Intent(this@CityListActivity, CityInfoActivity::class.java)
                intent.putExtra("city_id", city.id)
                startActivity(intent)
            }
        })

        vm.citiesLiveDta.observe(this) {
            adapter.cityList.addAll(it)
        }

        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@CityListActivity)
            recyclerView.adapter = adapter
        }
    }
}