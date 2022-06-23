package hse.ru.weatherapp.response

import com.google.gson.annotations.SerializedName
import hse.ru.weatherapp.models.WeatherEntity


class WeatherResponse {

    @SerializedName("weather")
    var weather: ArrayList<WeatherEntity>? = null
}
