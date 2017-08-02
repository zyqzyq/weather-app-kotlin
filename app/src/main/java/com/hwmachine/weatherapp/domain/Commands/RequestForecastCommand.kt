package com.hwmachine.weatherapp.domain.Commands

import com.hwmachine.weatherapp.ForecastRequest
import com.hwmachine.weatherapp.domain.model.ForecastList
import com.hwmachine.weatherapp.domain.datamapper.ForecastDataMapper

class RequestForecastCommand(val zipCode: String):Command<ForecastList>{

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}