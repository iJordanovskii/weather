package com.haselt.weatherapp.weather;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.haselt.weatherapp.common.Constants;
import com.haselt.weatherapp.model.Weather;
import com.haselt.weatherapp.network.WeatherApiService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {
    private Disposable disposable;
    public final MutableLiveData<Boolean> success;
    public final MutableLiveData<Boolean> showError;
    public final MutableLiveData<List<Weather>> weather;


    public HomeViewModel() {
        this.success = new MutableLiveData<>();
        this.showError = new MutableLiveData<>();
        this.weather = new MutableLiveData<>();
    }

    public void getWeatherByCity(String city) {
        disposable = WeatherApiService.getInstance()
                .getWeatherByCity(city, Constants.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response ->{
                    success.setValue(true);
                    weather.setValue(response.weather);
                    Log.d("HomeViewModel","success");
                }, error->{
                    Log.d("HomeViewModel","error",error);
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
