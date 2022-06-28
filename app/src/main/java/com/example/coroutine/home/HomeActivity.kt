package com.example.coroutine.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutine.animation.AnimationActivity
import com.example.coroutine.callMultiAPI.SecondActivity
import com.example.coroutine.callSingleAPI.MainActivity
import com.example.coroutine.databinding.ActivityHomeBinding
import com.example.coroutine.runblocking.BlockingThread
import com.example.coroutine.suspend.SuspendFunction

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        initEvent()
    }

    private fun initEvent() {
        goSuspendFunction()
        goBlockingThread()
        goCallSingleAPI()
        goCallMultiAPI()
        goAnimation()
    }

    private fun goAnimation() {
        homeBinding.animation.setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }
    }

    private fun goCallMultiAPI() {
        homeBinding.callMultiApi.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    private fun goCallSingleAPI() {
        homeBinding.callSingleApi.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun goBlockingThread() {
        homeBinding.blockingThread.setOnClickListener {
            startActivity(Intent(this, BlockingThread::class.java))
        }
    }

    private fun goSuspendFunction() {
        homeBinding.suspendFunction.setOnClickListener {
            startActivity(Intent(this, SuspendFunction::class.java))
        }
    }
}