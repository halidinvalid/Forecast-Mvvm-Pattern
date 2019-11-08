package com.halidinvalid.forecast.data.db.entity


import com.google.gson.annotations.SerializedName

data class Location(
    val name: String,
    val country: String,
    val region: String,
    val lat: String,
    val lon: String,
    @SerializedName("timezone_id")
    val timezoneId: String,
    val localtime: String,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int,
    @SerializedName("utc_offset")
    val utcOffset: String
)