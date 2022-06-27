package com.example.coroutine.callMultiAPI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.coroutine.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var secondBinding : ActivitySecondBinding
    private val secondViewModel : SecondViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(secondBinding.root)

        initObserverOne()
        initObserverTwo()
        secondViewModel.makeAPICall()
    }

    private fun initObserverOne() {
        secondViewModel.resultOne.observe(this) {resultOne ->
            when (resultOne) {
                is SecondViewModel.CallAPIOne.ResultOk -> {
                    Log.e("SecondActivity", resultOne.data.body().toString())
                    secondBinding.data1.text = resultOne.data.toString()
                }
                is SecondViewModel.CallAPIOne.ResultError -> {
                    Toast.makeText(this, resultOne.errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun initObserverTwo() {
        secondViewModel.resultTwo.observe(this) {resultTwo ->
            when (resultTwo) {
                is SecondViewModel.CallAPITwo.ResultOk -> {
                    Log.e("SecondActivity", resultTwo.data.body().toString())
                    secondBinding.data2.text = resultTwo.data.toString()
                }
                is SecondViewModel.CallAPITwo.ResultError -> {
                    Toast.makeText(this, resultTwo.errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}