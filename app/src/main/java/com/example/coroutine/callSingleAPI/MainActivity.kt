package com.example.coroutine.callSingleAPI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
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
    }

    private fun initObserver() {
        viewModel.result.observe(this) {result ->
            when (result) {
                is ViewModel.CallResult.ResultOk -> {
                    Log.e("MainActivity", result.message.body().toString())
                    binding.text.text = result.message.body().toString()
                }
                is ViewModel.CallResult.ResultError -> {
                    Toast.makeText(this, result.errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}