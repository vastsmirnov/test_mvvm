package com.vast.testmvvm.ui.cities.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vast.testmvvm.R
import com.vast.testmvvm.databinding.CityListItemBinding
import com.vast.testmvvm.domain.models.City

class CityListAdapter(private val onClickListener: CityOnClickListener) : RecyclerView.Adapter<CityListAdapter.CityListHolder>() {
    val cityList = ArrayList<City>()

    class CityListHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = CityListItemBinding.bind(item)
        fun bind(city: City) = with(binding) {
            tvId.text = city.id.toString()
            tvName.text = city.name.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityListHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.city_list_item, parent, false)

        return CityListHolder(view)
    }

    override fun onBindViewHolder(holder: CityListHolder, position: Int) {
        val city: City = cityList[position]
        holder.bind(city)
        holder.itemView.setOnClickListener {
            onClickListener.onClicked(city)
        }
    }

    override fun getItemCount(): Int {
        return cityList.size
    }
}