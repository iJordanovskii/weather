package com.haselt.weatherapp.weather;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haselt.weatherapp.common.ForecastAdapter;
import com.haselt.weatherapp.databinding.FragmentForecastBinding;
import com.haselt.weatherapp.model.Weather;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ForecastFragment extends Fragment {

    private FragmentForecastBinding binding;
    private ForecastViewModel viewModel;
    private ForecastAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentForecastBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ForecastViewModel.class);
        setupUi();


    }

    private void setupUi() {
        adapter = new ForecastAdapter();
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

//    private List<Weather> getWeather() {
//        List<Weather> weatherList = new ArrayList<>();
//        weatherList.add(new Weather(1, "Sunny", "03"));
//        weatherList.add(new Weather(2, "Cloudy", "04"));
//        return weatherList;
//    }


}