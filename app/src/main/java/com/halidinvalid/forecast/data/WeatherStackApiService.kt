package com.halidinvalid.forecast.data

import com.halidinvalid.forecast.data.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//http://api.weatherstack.com/current?access_key=b627bdebfd850fd167b2f77d7403da4c&query=New%20York

const val API_KEY = "b627bdebfd850fd167b2f77d7403da4c"

interface WeatherStackApiService {

    @GET("current")
    fun getCurrentWeather(
        @Query("query")
        location: String
    ): Deferred<CurrentWeatherResponse>

    companion object {
        operator fun invoke(): WeatherStackApiService {
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherStackApiService::class.java)
        }
    }
}