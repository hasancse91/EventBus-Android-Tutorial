package com.hellohasan.eventbuspractice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hellohasan.eventbuspractice.RetrofitClass.ApiInterface;
import com.hellohasan.eventbuspractice.RetrofitClass.RetrofitApiClient;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCallActivity extends AppCompatActivity {

    private final String myUrl = "https://raw.githubusercontent.com/hasancse91/EventBus-Android-Tutorial/master/Data/data.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_call);
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public void buttonClicked(View view) {
        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        Call<ResponseBody> call = apiInterface.getDataFromServer(myUrl);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                Logger.d("Response: " + response.message());
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Logger.d("Failure: " + t.toString());
            }
        });
    }
}
