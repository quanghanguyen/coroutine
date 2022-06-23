package com.example.coroutine.callMultiAPI

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    var okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(
            Interceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.header("X-Auth-Token", "161d94ea5ccd478596a33f51876bd457")
                return@Interceptor chain.proceed(builder.build())
            }
        )
    }
    var client : OkHttpClient = okHttpClient.build()
    private const val BASE_URL : String = "https://api.football-data.org"

    fun getRetrofitInstance() : Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}