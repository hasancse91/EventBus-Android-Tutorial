package com.hellohasan.eventbuspractice.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hellohasan.eventbuspractice.Model.DataReceiveEvent;
import com.hellohasan.eventbuspractice.R;
import com.hellohasan.eventbuspractice.RetrofitClass.ApiInterface;
import com.hellohasan.eventbuspractice.RetrofitClass.NetworkCall;
import com.hellohasan.eventbuspractice.RetrofitClass.RetrofitApiClient;
import com.hellohasan.eventbuspractice.Util.Config;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_call);
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public void buttonClicked(View view) {
        NetworkCall.getData();
        finish();
    }
}
