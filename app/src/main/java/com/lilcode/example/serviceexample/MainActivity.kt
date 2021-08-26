package com.lilcode.example.serviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.JobIntentService
import com.lilcode.example.serviceexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = requireNotNull(_binding)

    val SERVICE_ID = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun buttonClick(view: View) {
        // 시작시킬 서비스의 클래스 이름을 갖는 새로운 인텐트 객체 생성 후 이것을 startService 에 넘김
        JobIntentService.enqueueWork(this, MyJobIntentService::class.java, SERVICE_ID, intent)
    }

    fun buttonClick2(view: View) {
        intent = Intent(this, MyService::class.java)
        startService(intent)
    }
}