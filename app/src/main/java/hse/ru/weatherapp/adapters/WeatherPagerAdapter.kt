package hse.ru.weatherapp.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import hse.ru.weatherapp.R
import hse.ru.weatherapp.databinding.PagerContainerBinding
import hse.ru.weatherapp.listeners.ImageListener
import hse.ru.weatherapp.models.DayEntity
import java.lang.NumberFormatException
import java.time.Instant
import java.time.ZoneId

class WeatherPagerAdapter(sliderWeatherInfo: ArrayList<DayEntity>, context_: Context) :
    RecyclerView.Adapter<WeatherPagerAdapter.WeatherPagerViewHolder>() {
    private var weatherInfo: ArrayList<DayEntity> = ArrayList()
    private var layoutInflater: LayoutInflater? = null
    var context: Context = context_


    init {
        this.weatherInfo = sliderWeatherInfo
    }

    inner class WeatherPagerViewHolder(itemContainerSliderImageBinding: PagerContainerBinding) :
        RecyclerView.ViewHolder(itemContainerSliderImageBinding.root) {
        private var binding: PagerContainerBinding? = null

        init {
            this.binding = itemContainerSliderImageBinding
        }

        fun bindSliderImage(weatherInfo: DayEntity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                try {
                    weatherInfo.dateTime = Instant.ofEpochSecond(weatherInfo.dateTime.toLong())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime().toString().substringBefore("T")
                    weatherInfo.sunrise = Instant.ofEpochSecond(weatherInfo.sunrise.toLong())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime().toString().substringAfter("T")
                    weatherInfo.sunset = Instant.ofEpochSecond(weatherInfo.sunset.toLong())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime().toString().substringAfter("T")
                    when (weatherInfo.weather[0].description) {
                        "ясно" -> binding!!.imageWeather.background =
                            ContextCompat.getDrawable(context, R.drawable.clear)
                        "облачно" -> binding!!.imageWeather.background =
                            ContextCompat.getDrawable(context, R.drawable.cloudy)
                        "пасмурно", "дождь", "небольшой дождь" -> binding!!.imageWeather.background =
                            ContextCompat.getDrawable(context, R.drawable.rainy)
                        "облачно с прояснениями" -> binding!!.imageWeather.background =
                            ContextCompat.getDrawable(context, R.drawable.partly_cloudy)
                        else -> binding!!.imageWeather.background =
                            ContextCompat.getDrawable(context, R.drawable.partly_cloudy)
                    }

                } catch (e: NumberFormatException) {

                }
            }
            binding?.weatherInfo = weatherInfo
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherPagerViewHolder {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.context)
        val sliderImageBinding: PagerContainerBinding = DataBindingUtil.inflate(
            layoutInflater!!, R.layout.pager_container, parent, false
        )
        return WeatherPagerViewHolder(sliderImageBinding)
    }

    override fun onBindViewHolder(holder: WeatherPagerViewHolder, position: Int) {
        weatherInfo?.get(position)
            ?.let { holder.bindSliderImage(it) }

    }

    override fun getItemCount(): Int {
        return weatherInfo!!.size
    }
}