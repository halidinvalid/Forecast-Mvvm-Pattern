package com.halidinvalid.forecast.data.response

import com.google.gson.annotations.SerializedName
import com.halidinvalid.forecast.data.db.entity.CurrentWeatherEntry
import com.halidinvalid.forecast.data.db.entity.Location
import com.halidinvalid.forecast.data.db.entity.Request


data class CurrentWeatherResponse(
    @SerializedName("request")
    val request: Request,
    @SerializedName("location")
    val location: Location,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)