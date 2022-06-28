package com.example.coroutine.callSingleAPI

import android.R
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutine.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObserver()
        viewModel.makeAPICall()

//        val animation1 = AnimationUtils.loadAnimation(this,R.anim.fade_out).duration
//        binding.text.animation = animation1
    }

    private fun initObserver() {
        viewModel.result.observe(this) {result ->
            when (result) {
                is ViewModel.CallResult.ResultOk -> {
                    Log.e("MainActivity", result.data.body().toString())
                    binding.text.text = result.data.body().toString()
                }
                is ViewModel.CallResult.ResultError -> {
                    Toast.makeText(this, result.errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}