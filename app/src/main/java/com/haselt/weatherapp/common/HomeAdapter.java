package com.haselt.weatherapp.common;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.haselt.weatherapp.databinding.ItemWeatherNowBinding;
import com.haselt.weatherapp.model.Weather;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private List<Weather> weather = new ArrayList<>();

    public void addAll(List<Weather> weatherList) {
        weather.clear();
        weather.addAll(weatherList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemWeatherNowBinding binding = ItemWeatherNowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HomeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.bind(weather.get(position));

    }

    @Override
    public int getItemCount() {
        return weather.size();
    }

    static class HomeViewHolder extends RecyclerView.ViewHolder {
        ItemWeatherNowBinding binding;

        public HomeViewHolder(@NonNull ItemWeatherNowBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(Weather weather) {

            binding.description.setText(weather.title.toUpperCase());
            binding.descLong.setText(weather.mainDescription.toUpperCase());
            Glide.with(binding.weatherIcon.getContext())
                    .load(Constants.BASE_IMG_URL+weather.image+".png")
                    .into(binding.weatherIcon);
        }

    }
}