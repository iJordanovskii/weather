package com.haselt.weatherapp.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import  com.bumptech.glide.annotation.compiler.*;
import com.haselt.weatherapp.databinding.ItemDayForecastBinding;
import com.haselt.weatherapp.model.Weather;
import com.haselt.weatherapp.model.WeatherApiResponse;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private final List<Weather> weather = new ArrayList<>();

    public void addAll(List<Weather> weatherList) {
        weather.clear();
        weather.addAll(weatherList);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder( @NotNull ViewGroup parent, int viewType) {
        ItemDayForecastBinding binding = ItemDayForecastBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ForecastViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull  ForecastViewHolder holder, int position) {
        holder.bind(weather.get(position));
    }

    @Override
    public int getItemCount() {
        return weather.size();
    }

    static class ForecastViewHolder extends RecyclerView.ViewHolder {
        ItemDayForecastBinding binding;
        public ForecastViewHolder(@NonNull ItemDayForecastBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(Weather weather) {
            binding.description.setText(weather.title);
            Glide.with(binding.image.getContext())
                    .load(weather.image)
                    .into(binding.image);
        }
    }
}
