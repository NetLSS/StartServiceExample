package com.lilcode.example.serviceexample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.lang.Exception

class MyService : Service() {

    private val TAG = "ServiceExample"

    override fun onCreate() {
        Log.i(TAG, "Service onCreate")
    }

    // 제대로 동작하는 서비스를 위해 오버라이딩
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "Service onStartCommand " + startId)
        var i: Int = 0
        while (i <= 3) {
            try {
                Thread.sleep(10_000)
                i++
            } catch (e: Exception) {
            }
            Log.i(TAG,"Service running")
        }
        return Service.START_STICKY
    }

    override fun onBind(intent: Intent): IBinder {
        Log.i(TAG, "Service onBind")
        TODO("Return the communication channel to the service.")
        // 바운드 서비스가 아니라는 것을 안드로이드 시스템에게 알려주기 위해 null 값을 반환.
    }

    override fun onDestroy() {
        Log.i(TAG, "Service onDestroy")
        super.onDestroy()
    }
}