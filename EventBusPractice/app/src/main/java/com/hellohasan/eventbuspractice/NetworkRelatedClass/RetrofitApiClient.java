package com.hellohasan.eventbuspractice.NetworkRelatedClass;

import retrofit2.Retrofit;

public class RetrofitApiClient {

    private static final String BASE_URL = "http://54.255.242.140/";

    private static Retrofit retrofit = null;

    private RetrofitApiClient() {} // So that nobody can create an object with constructor

    public static synchronized Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }
}
