package com.hwmachine.weatherapp

import java.net.URL
import com.google.gson.Gson

public class ForecastRequest(val zipCode: String){
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" + "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="

    }
    fun execute(): ForecastReslut{
        val forecastJsonStr = URL(COMPLETE_URL+zipCode).readText()
        return Gson().fromJson(forecastJsonStr,ForecastReslut::class.java)
    }
}