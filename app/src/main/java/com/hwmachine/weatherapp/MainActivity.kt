package com.hwmachine.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.hwmachine.weatherapp.domain.Commands.RequestForecastCommand
import com.hwmachine.weatherapp.domain.model.Forecast
import com.hwmachine.weatherapp.ui.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this)
        //forecastList.adapter = ForecastListAdapter(items)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            Log.d("TTSS", "getanswer")
            Log.d("TTSS", result.toString())
        uiThread {
            forecastList.adapter = ForecastListAdapter(result,
                    object: ForecastListAdapter.OnItemClickListener{
                        override fun invoke(forecast: Forecast) {
                            toast(forecast.date)
                        }
                    })
            }
        }

    }
}
