package com.haselt.weatherapp.model;

import com.google.gson.annotations.SerializedName;

public class Weather {
    public int id;
    @SerializedName("main")
    public String title;
    @SerializedName("icon")
    public String image;
    @SerializedName("description")
    public String mainDescription;
    @SerializedName("temp")
    public String temperature;
    @SerializedName("lon")
    public String lon;
    @SerializedName("lat")
    public String lat;
}
