package com.haselt.weatherapp.network;

import com.haselt.weatherapp.model.WeatherApiResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("data/2.5/weather")
    Single<WeatherApiResponse> getWeatherByCity(@Query("q") String city, @Query("appid") String apiKey);
}
