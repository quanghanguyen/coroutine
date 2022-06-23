package com.example.coroutine.callAPI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutine.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            Log.e("MainActivity: ", result.body().toString())
        }
    }
}