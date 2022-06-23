package com.example.coroutine.callMultiAPI.apiInterface

import com.example.coroutine.callMultiAPI.model.two.TeamsModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface One {
    @GET("v2/competitions/{id}/teams")
    suspend fun getTeamDetail(@Path("id") id : Int) : Response<TeamsModel>
}