package com.hellohasan.eventbuspractice.NetworkRelatedClass;

import retrofit2.Retrofit;

public class RetrofitApiClient {

    /**
        For this App we don't use base URL. Because we used dynamic URL
        but we've to call .baseUrl(YOUR_BASE_URL) method with any URL.
        So here I mentioned a fake URL.
     */
    private static final String BASE_URL = "http://your-base-url";

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
