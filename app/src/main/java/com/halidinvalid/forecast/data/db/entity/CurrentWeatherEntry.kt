package com.halidinvalid.forecast.data.db.entity


import com.google.gson.annotations.SerializedName

data class CurrentWeatherEntry(
    @SerializedName("observation_time")
    val observationTime: String,
    val temperature: Int,
    @SerializedName("weather_code")
    val weatherCode: Int,
    @SerializedName("weather_icons")
    val weatherIcons: List<String>,
    @SerializedName("weather_descriptions")
    val weatherDescriptions: List<String>,
    @SerializedName("wind_speed")
    val windSpeed: Int,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_dir")
    val windDir: String,
    val pressure: Int,
    val precip: Double,
    val humidity: Int,
    val cloudcover: Int,
    val feelslike: Int,
    @SerializedName("uv_index")
    val uvIndex: Int,
    val visibility: Int,
    @SerializedName("is_day")
    val isDay: String
)