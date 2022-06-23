package hse.ru.weatherapp.listeners

import hse.ru.weatherapp.models.HourEntity

interface WeatherListener {
    fun onWeatherClicked(hourEntity: HourEntity)
}