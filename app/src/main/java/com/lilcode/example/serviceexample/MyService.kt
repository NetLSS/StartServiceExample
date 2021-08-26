package com.lilcode.example.serviceexample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class MyService : Service(), CoroutineScope {

    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + job

    private val TAG = "ServiceExample"

    override fun onCreate() {
        Log.i(TAG, "Service onCreate")
        job = Job()
    }

    // 제대로 동작하는 서비를 위해 오버라이딩
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        launch(coroutineContext){
            performTask(startId)
        }
        return Service.START_STICKY
    }

    suspend fun performTask(startId: Int) {
        Log.i(TAG, "Service onStartCommand " + startId)
        var i: Int = 0
        while (i <= 3) {
            try {
                delay(10_000)
                i++
            } catch (e: Exception) {
            }
            Log.i(TAG, "Service running " + startId)
        }
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