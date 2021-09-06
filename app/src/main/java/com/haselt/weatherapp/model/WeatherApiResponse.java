package com.haselt.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherApiResponse {

    @SerializedName("weather")
    public final List<Weather> weather;

    public WeatherApiResponse(List<Weather> weather) {
        this.weather = weather;

    }
}
