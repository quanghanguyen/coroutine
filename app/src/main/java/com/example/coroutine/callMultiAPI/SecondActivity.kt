package com.example.coroutine.callMultiAPI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutine.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var sencondBinding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sencondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(sencondBinding.root)
    }
}