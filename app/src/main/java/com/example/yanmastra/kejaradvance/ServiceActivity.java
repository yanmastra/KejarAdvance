package com.example.yanmastra.kejaradvance;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.yanmastra.kejaradvance.receiver.MyBroadcastReceiver;
import com.example.yanmastra.kejaradvance.service.MyService;

/**
 * Created by Yan Mastra on 11/12/2017.
 */

public class ServiceActivity extends AppCompatActivity {

    private MyBroadcastReceiver broadcastReceiver = new MyBroadcastReceiver();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.service_activity);
        super.onCreate(savedInstanceState);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(broadcastReceiver, filter);

        Button btnStartService = findViewById(R.id.btn_service);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(ServiceActivity.this, MyService.class));
            }
        });


    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }
}
