package com.hellohasan.eventbuspractice.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hellohasan.eventbuspractice.Model.DataReceiveEvent;
import com.hellohasan.eventbuspractice.R;
import com.hellohasan.eventbuspractice.Util.Config;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(DataReceiveEvent event) throws ClassNotFoundException {

        if (event.isTagMatchWith(Config.DATA_RECEIVED)) {
            textView.setText("Response message from server: " + event.getResponseMessage());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        textView.setText("Response message from server: Not Received Yet");
    }

    public void buttonClicked(View view) {
        startActivity(new Intent(this, NetworkCallActivity.class));
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
