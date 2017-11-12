package com.example.yanmastra.kejaradvance.service;

/**
 * Created by Yan Mastra on 11/12/2017.
 */

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = MyService.class.getSimpleName();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "SERVICE STARTED");

        new DoSomething().execute();

        return super.onStartCommand(intent, flags, startId);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class DoSomething extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i=0; i<=10; i++) {
                try {
                    Thread.sleep(1000);
                    Log.i(TAG, "do in background : " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
