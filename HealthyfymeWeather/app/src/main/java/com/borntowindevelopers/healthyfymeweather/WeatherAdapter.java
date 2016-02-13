package com.borntowindevelopers.healthyfymeweather;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<WeatherInfo> weatherList;
private Context context;
    public WeatherAdapter(List<WeatherInfo> weatherList,Context context) {
        this.weatherList = weatherList;
        this.context=context;
    }


    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder weatherViewHolder, int i) {

        // To set the text in textview

        WeatherInfo wi = weatherList.get(i);
        weatherViewHolder.vcity.setText(wi.city);
        weatherViewHolder.vdescription.setText(wi.description);
        Glide.with(context)
               .load(R.drawable.weather).override(300, 200)
             .diskCacheStrategy(DiskCacheStrategy.ALL)
           .into(weatherViewHolder.vimage);

    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardlayout, viewGroup, false);

        return new WeatherViewHolder(itemView);
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {

        protected TextView vcity;
        protected TextView vdescription;
        protected ImageView vimage;


       // to link the xml widget
        public WeatherViewHolder(View v) {

            super(v);
            vcity=  (TextView) v.findViewById(R.id.city);
            vdescription = (TextView)  v.findViewById(R.id.Description);
            vimage = (ImageView)  v.findViewById(R.id.Weatherimage);

        }
    }
}