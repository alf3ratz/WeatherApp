package hse.ru.weatherapp.viewmodels

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import hse.ru.weatherapp.repositories.WeatherRepository
import hse.ru.weatherapp.response.WeatherResponse
import hse.ru.weatherapp.responses.DayResponse
import hse.ru.weatherapp.responses.HourlyResponse

class WeatherViewModel(@NonNull application: Application) : AndroidViewModel(application) {
    private var loginRepository: WeatherRepository =
        WeatherRepository()

    fun getCityWeather(city:String,apiKey:String): LiveData<WeatherResponse> {
        return loginRepository.getCityWeather(city,apiKey)
    }


    fun getWeatherAtLastHour(apiKey:String): LiveData<HourlyResponse> {
        return loginRepository.getWeatherAtLastHour(apiKey)
    }

    fun getWeatherAtLastDay(lat:String, lon:String,apiKey:String):LiveData<DayResponse>{
        return loginRepository.getWeatherAtLastDay(lat,lon,apiKey)
    }
}