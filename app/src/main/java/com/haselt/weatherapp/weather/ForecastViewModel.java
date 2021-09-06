package com.haselt.weatherapp.weather;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.haselt.weatherapp.common.Constants;
import com.haselt.weatherapp.model.Weather;
import com.haselt.weatherapp.model.WeatherApiResponse;
import com.haselt.weatherapp.network.ApiService;
import com.haselt.weatherapp.network.WeatherApiService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ForecastViewModel extends ViewModel {

}
