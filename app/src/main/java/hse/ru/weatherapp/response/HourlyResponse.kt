package hse.ru.weatherapp.responses

import com.google.gson.annotations.SerializedName
import hse.ru.weatherapp.models.HourEntity

class HourlyResponse {
    @SerializedName("timezone")
    var timezone: String = "default"

    @SerializedName("hourly")
    var hourlyWeather: ArrayList<HourEntity> = ArrayList()
}