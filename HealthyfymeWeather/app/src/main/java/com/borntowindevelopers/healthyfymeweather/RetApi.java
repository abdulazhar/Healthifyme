package com.borntowindevelopers.healthyfymeweather;
import retrofit.Callback;
import retrofit.http.GET;

    /**
     * Created by Belal on 11/3/2015.
     */
    public interface RetApi {

        /*Retrofit get annotation with URL
        Method for five cities weather
        */
        @GET("/weather?q=Chennai,IN&appid=4a83799a557329e0347b2e903b9e3bf4")
        public void getWeather(Callback<WeatherDetail> res) ;

        @GET("/weather?q=Mumbai,IN&appid=4a83799a557329e0347b2e903b9e3bf4")
        public void getWeather1(Callback<WeatherDetail> res) ;

        @GET("/weather?q=Delhi,IN&appid=4a83799a557329e0347b2e903b9e3bf4")
        public void getWeather2(Callback<WeatherDetail> res) ;

        @GET("/weather?q=Kolkata,IN&appid=4a83799a557329e0347b2e903b9e3bf4")
        public void getWeather3(Callback<WeatherDetail> res) ;

        @GET("/weather?q=Cochin,IN&appid=4a83799a557329e0347b2e903b9e3bf4")
        public void getWeather4(Callback<WeatherDetail> res) ;

    }


