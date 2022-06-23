package com.example.coroutine.callMultiAPI.apiInterface

import com.example.coroutine.callMultiAPI.model.one.ChartModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Two {
    @GET("v2/competitions/{id}/standings?standingType=HOME")
    suspend fun getChartDetail(@Path("id") id : Int) : Response<ChartModel>
}