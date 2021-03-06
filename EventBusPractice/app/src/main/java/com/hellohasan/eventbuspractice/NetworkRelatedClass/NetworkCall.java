package com.hellohasan.eventbuspractice.NetworkRelatedClass;

import android.support.annotation.NonNull;

import com.hellohasan.eventbuspractice.Model.DataReceiveEvent;
import com.hellohasan.eventbuspractice.Util.Config;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCall {
    public static void getData(){
        Logger.addLogAdapter(new AndroidLogAdapter());
        String myUrl = "https://raw.githubusercontent.com/hasancse91/EventBus-Android-Tutorial/master/Data/data.json";

        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        Call<ResponseBody> call = apiInterface.getDataFromServer(myUrl);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                Logger.d("Response: " + response.message());
                EventBus.getDefault().post(new DataReceiveEvent(Config.DATA_RECEIVED, response.message()));
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Logger.d("Failure: " + t.toString());
                EventBus.getDefault().post(new DataReceiveEvent(Config.DATA_RECEIVED, t.toString()));
            }
        });
    }
}
