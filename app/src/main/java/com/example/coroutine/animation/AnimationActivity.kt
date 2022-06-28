package com.example.coroutine.animation

import android.R
import android.animation.ValueAnimator
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import com.example.coroutine.databinding.ActivityAnimationBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AnimationActivity : AppCompatActivity() {

    private lateinit var animationBinding: ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        animationBinding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(animationBinding.root)

        startAnimation()
//        startLoop()
        startLoopCoroutine()
    }

    private fun startAnimation() {
        val animation1 = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
        animation1.duration = 7000
        animationBinding.android.animation = animation1
    }

    private fun startLoop() {
        for (i in 1..1000000000) {
            Log.e("Number: ", i.toString())
        }
    }

    private fun startLoopCoroutine() {
        GlobalScope.launch {
            for (i in 1..1000000000) {
                Log.e("Number: ", i.toString())
            }
        }
    }
}