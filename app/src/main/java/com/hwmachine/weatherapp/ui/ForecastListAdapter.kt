package com.hwmachine.weatherapp.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hwmachine.weatherapp.domain.model.Forecast
import com.hwmachine.weatherapp.R
import com.hwmachine.weatherapp.ctx
import com.hwmachine.weatherapp.domain.model.ForecastList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastListAdapter(val weekForecast: ForecastList,
                          val itemClick: OnItemClickListener)
        :RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){
    public interface OnItemClickListener{
        operator fun invoke(forecast: Forecast)
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.ctx)
                .inflate(R.layout.item_forecast,parent,false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(weekForecast[position]){
            holder?.bindForecast(weekForecast[position])
        }
    }

    override fun getItemCount(): Int = weekForecast.size()
    class ViewHolder(view: View ,val itemClick: OnItemClickListener)
        :RecyclerView.ViewHolder(view){
        fun bindForecast(forecast: Forecast){
            with(forecast){
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }
    }
}