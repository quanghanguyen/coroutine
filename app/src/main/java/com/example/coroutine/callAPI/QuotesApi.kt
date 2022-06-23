package com.example.coroutine.callAPI

import com.example.coroutine.callAPI.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>
}