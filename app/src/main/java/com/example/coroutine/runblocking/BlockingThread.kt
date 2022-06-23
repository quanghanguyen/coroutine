package com.example.coroutine.runblocking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutine.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class BlockingThread : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blocking_thread)

        action()
        Log.e("BlockingThread", "World")
    }

    private fun action() = runBlocking {

        Log.e("BlockingThread", "Hello")
        delay(3000)

        Log.e("BlockingThread","Beautiful")
        delay(3000)
    }
}