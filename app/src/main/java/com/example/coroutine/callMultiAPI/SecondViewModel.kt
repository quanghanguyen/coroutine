package com.example.coroutine.callMultiAPI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutine.callMultiAPI.apiInterface.One
import com.example.coroutine.callMultiAPI.apiInterface.Two
import com.example.coroutine.callMultiAPI.model.one.ChartModel
import com.example.coroutine.callMultiAPI.model.two.TeamsModel
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class SecondViewModel : ViewModel() {
    val resultOne = MutableLiveData<CallAPIOne>()
    val resultTwo = MutableLiveData<CallAPITwo>()

    sealed class CallAPIOne {
        class ResultOk(val data: Response<TeamsModel>) : CallAPIOne()
        class ResultError(val errorMessage : String) : CallAPIOne()
    }

    sealed class CallAPITwo {
        class ResultOk(val data : Response<ChartModel>) : CallAPITwo()
        class ResultError(val errorMessage : String) : CallAPITwo()
    }

    fun makeAPICall() {
        val one = RetrofitInstance.getRetrofitInstance().create(One::class.java)
        val two = RetrofitInstance.getRetrofitInstance().create(Two::class.java)

        runBlocking {
            val dataOne = async{ one.getTeamDetail(2019) }
                resultOne.postValue(CallAPIOne.ResultOk(dataOne.await()))

            val dataTwo = async { two.getChartDetail(2019) }
            resultTwo.postValue(CallAPITwo.ResultOk(dataTwo.await()))
        }
    }
}