package com.example.coroutine.suspend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutine.databinding.ActivityMainBinding
import com.example.coroutine.databinding.ActivitySuspendBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SuspendFunction : AppCompatActivity() {

    private lateinit var suspendBinding : ActivitySuspendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        suspendBinding = ActivitySuspendBinding.inflate(layoutInflater)
        setContentView(suspendBinding.root)

        GlobalScope.launch {
            val networkCallAnswer = doNetworkCall()
            Log.e("Suspend-Activity", networkCallAnswer)
        }
    }
    private suspend fun doNetworkCall() : String {
        delay(3000L)
        return "Hello"
    }
}