package com.hellohasan.eventbuspractice;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hellohasan.eventbuspractice.RetrofitClass.ApiInterface;
import com.hellohasan.eventbuspractice.RetrofitClass.RetrofitApiClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void buttonClicked(View view) {


    }
}
