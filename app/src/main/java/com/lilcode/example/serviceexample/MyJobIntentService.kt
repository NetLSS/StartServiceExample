package com.lilcode.example.serviceexample

import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService
import java.lang.Exception

// Deprecated 되었음.. WorkManager 에 대해서 알아볼것.
class MyJobIntentService : JobIntentService(){

    private val TAG = "ServiceExample"

    override fun onHandleWork(intent: Intent) {
        Log.i(TAG, "Job Service started")

        var i: Int = 0

        while (i <= 3) {
            try {
                Thread.sleep(10_000)
                i++
            } catch (e: Exception) {
            }

            Log.i(TAG, "Service running")
        }
    }

}