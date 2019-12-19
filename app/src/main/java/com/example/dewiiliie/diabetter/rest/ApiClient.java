package com.example.dewiiliie.diabetter.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
        public static final String BASE_URL = "https://www.satriaboma15.com/diabetter-api/";
//    public static final String BASE_URL = "http://localhost/diabetter-api/";
//    public static final String BASE_URL = "http://192.168.43.115/diabetter-api/"; //Tethering HP
//    public static final String BASE_URL = "http://192.168.0.5/diabetter-api/"; //Wifi Nico
//    public static final String BASE_URL = "http://192.168.1.111/diabetter-api/"; //Wifi kost
//    public static final String BASE_URL = "http://172.16.87.211/diabetter-api/"; //wifi umn


    private static Retrofit retrofit =  null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
