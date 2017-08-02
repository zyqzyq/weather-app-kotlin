package com.hwmachine.weatherapp.domain.datamapper

import com.hwmachine.weatherapp.Forecast
import com.hwmachine.weatherapp.ForecastReslut
import com.hwmachine.weatherapp.domain.model.Forecast as ModelForecast
import com.hwmachine.weatherapp.domain.model.ForecastList
import java.text.DateFormat
import java.util.*

class ForecastDataMapper{
    fun convertFromDataModel(forecast:ForecastReslut): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }
    fun convertForecastListToDomain(list:List<Forecast>): List<ModelForecast>{
        return list.map { converForecastItemToDomain(it) }
    }
    private fun converForecastItemToDomain(forecast: Forecast):ModelForecast{
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description,forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon))
    }
    private fun convertDate(date: Long): String{
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
    private fun generateIconUrl(iconCode: String): String
        =  "http://openweathermap.org/img/w/$iconCode.png"

}