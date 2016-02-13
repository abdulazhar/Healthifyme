package com.borntowindevelopers.healthyfymeweather;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/* Retrofit is done to fetch the weather details for five cities in mainactivity
   Recyclerview is done.
   inside the recyclerview cardview is done.
   Glide is done in WeatherAdapter.


*/
//POJO CLASSES ARE Clouds,Coord,Main,Rain,Weather,Wind,Sys

//RETROFIT INTERFACE IS RetApi

//weatherAdapter is used to link cardview in recyclerview in dynamically using ViewHolder






public class MainActivity extends AppCompatActivity {

protected  static  String[] arraycity=new String[5];
  protected  static String[] arraydescription=new String[5];

       //open api url

    public static final String url = "http://api.openweathermap.org/data/2.5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        RecyclerView recList = (RecyclerView) findViewById(R.id.RecycleList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        WeatherAdapter wa = new WeatherAdapter(createList(5),this);
        recList.setAdapter(wa);


             //Creating Restadapter object
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(url).build();

        //Creating Rest Services
        RetApi restInterface = adapter.create(RetApi.class);

        //Calling method to get whether reports for five cities like chennai,mumbai,delhi,kolkata,cochin.

        restInterface.getWeather(new Callback<WeatherDetail>() {
            @Override
            public void success(WeatherDetail weatherDetail, retrofit.client.Response response) {

                arraycity[0] = weatherDetail.getName();

                SharedPreferences sp = MainActivity.this.getSharedPreferences("PREF_FILE", MODE_PRIVATE);
                SharedPreferences.Editor spe = sp.edit();
                spe.putString("city1",arraycity[0] );
                spe.commit();
                arraydescription[0] = "Humidity:" + weatherDetail.getMain().getHumidity().toString() + " Temp:" + weatherDetail.getMain().getTemp().toString() + " Lon:" + weatherDetail.getCoord().getLon().toString()+" Lat:" + weatherDetail.getCoord().getLat().toString();
                sp = MainActivity.this.getSharedPreferences("PREF_FILE", MODE_PRIVATE);
                spe = sp.edit();
                spe.putString("desc1", arraydescription[0]);
                spe.commit();
                Log.d("1", arraycity[0]);
            }



            @Override
            public void failure(RetrofitError error) {
                String merror = error.getMessage();
                Log.d("hello1",merror);
            }


        });


        restInterface.getWeather1(new Callback<WeatherDetail>() {
            @Override
            public void success(WeatherDetail weatherDetail, retrofit.client.Response response) {
                arraycity[1]=weatherDetail.getName();

                SharedPreferences sp = MainActivity.this.getSharedPreferences("PREF_FILE", MODE_PRIVATE);
                SharedPreferences.Editor spe = sp.edit();
                spe.putString("city2", arraycity[1]);
                spe.commit();
                Log.d("hello",arraycity[1]);
                arraydescription[1] = "Humidity:" + weatherDetail.getMain().getHumidity().toString() + " Temp:" + weatherDetail.getMain().getTemp().toString()+" Lon:" + weatherDetail.getCoord().getLon().toString()+" Lat:" + weatherDetail.getCoord().getLat().toString();

                sp = MainActivity.this.getSharedPreferences("PREF_FILE", MODE_PRIVATE);
                spe = sp.edit();
                spe.putString("desc2", arraydescription[1]);
                spe.commit();
            }

            @Override
            public void failure(RetrofitError error) {
                String merror = error.getMessage();
                Log.d("hello",merror);

            }


        });

        restInterface.getWeather2(new Callback<WeatherDetail>() {
            @Override
            public void success(WeatherDetail weatherDetail, retrofit.client.Response response) {
                arraycity[2] = weatherDetail.getName();

                SharedPreferences sp = MainActivity.this.getSharedPreferences("PREF_FILE", MODE_PRIVATE);
                SharedPreferences.Editor spe = sp.edit();
                spe.putString("city3",arraycity[2] );
                spe.commit();
                arraydescription[2] = "Humidity:"+ weatherDetail.getMain().getHumidity().toString() + " Temp:" + weatherDetail.getMain().getTemp().toString() + " Lon:" + weatherDetail.getCoord().getLon().toString()+" Lat:" + weatherDetail.getCoord().getLat().toString();
                sp = MainActivity.this.getSharedPreferences("PREF_FILE", MODE_PRIVATE);
                spe = sp.edit();
                spe.putString("desc3", arraydescription[2]);
                spe.commit();
            }

            @Override
            public void failure(RetrofitError error) {
                String merror = error.getMessage();

            }


        });

        RetApi restInterface3 = adapter.create(RetApi.class);
        restInterface3.getWeather3(new Callback<WeatherDetail>() {
            @Override
            public void success(WeatherDetail weatherDetail, retrofit.client.Response response) {
                arraycity[3] = weatherDetail.getName();

                SharedPreferences sp = MainActivity.this.getSharedPreferences("PREF_FILE", MODE_PRIVATE);
                SharedPreferences.Editor spe = sp.edit();
                spe.putString("city4",arraycity[3] );
                spe.commit();
                arraydescription[3] = "Humidity:" + weatherDetail.getMain().getHumidity().toString() + " Temp:" + weatherDetail.getMain().getTemp().toString() + " Lon:" + weatherDetail.getCoord().getLon().toString()+" Lat:" + weatherDetail.getCoord().getLat().toString();
                sp = MainActivity.this.getSharedPreferences("PREF_FILE", MODE_PRIVATE);
                spe = sp.edit();
                spe.putString("desc4", arraydescription[3]);
                spe.commit();
            }
            @Override
            public void failure(RetrofitError error) {
                String merror = error.getMessage();

            }


        });
        RetApi restInterface4 = adapter.create(RetApi.class);
        restInterface4.getWeather4(new Callback<WeatherDetail>() {
            @Override
            public void success(WeatherDetail weatherDetail, retrofit.client.Response response) {
                arraycity[4] = weatherDetail.getName();

                SharedPreferences sp = MainActivity.this.getSharedPreferences("PREF_FILE", MODE_PRIVATE);
                SharedPreferences.Editor spe = sp.edit();
                spe.putString("city5",arraycity[4] );
                spe.commit();
                arraydescription[4] = "Humidity:" + weatherDetail.getMain().getHumidity().toString() + " Temp:" + weatherDetail.getMain().getTemp().toString() + " Lon:" + weatherDetail.getCoord().getLon().toString()+" Lat:" + weatherDetail.getCoord().getLat().toString();
                sp = MainActivity.this.getSharedPreferences("PREF_FILE", MODE_PRIVATE);
                spe = sp.edit();
                spe.putString("desc5", arraydescription[4]);
                spe.commit();
            }

            @Override
            public void failure(RetrofitError error) {
                String merror = error.getMessage();
            }


        });

    }

//to store the weather info in weatherInfo
    List<WeatherInfo> createList(int size) {

        List<WeatherInfo> result = new ArrayList<WeatherInfo>();

        //To get the weather details from sharedpreference

        SharedPreferences sp=MainActivity.this.getSharedPreferences("PREF_FILE", MODE_PRIVATE);
        arraycity[0]=sp.getString("city1","");
        arraycity[1]=sp.getString("city2","");
        arraycity[2]=sp.getString("city3","");
        arraycity[3]=sp.getString("city4","");
        arraycity[4]=sp.getString("city5","");
        arraydescription[0]=sp.getString("desc1","");
        arraydescription[1]=sp.getString("desc2","");
        arraydescription[2]=sp.getString("desc3","");
        arraydescription[3]=sp.getString("desc4","");
        arraydescription[4]=sp.getString("desc5","");

        for (int i=0; i <size; i++) {
            WeatherInfo ci = new WeatherInfo();
            ci.city = arraycity[i];

            ci.description = arraydescription[i];


            result.add(ci);

        }

        return result;
    }

}
