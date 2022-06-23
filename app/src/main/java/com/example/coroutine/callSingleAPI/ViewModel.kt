package com.example.coroutine.callSingleAPI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutine.callSingleAPI.model.QuoteList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModel : ViewModel() {

    var result = MutableLiveData<CallResult>()

    sealed class CallResult {
        class ResultOk(val data : Response<QuoteList>) : CallResult()
        class ResultError(val errorMessage : String) : CallResult()
    }

    fun makeAPICall() {
        val quotesApi = RetrofitHelper.getRetrofitInstance().create(QuotesApi::class.java)
        GlobalScope.launch {
            val quotesApiCall = quotesApi.getQuotes()
            if (quotesApiCall.isSuccessful){
                result.postValue(CallResult.ResultOk(quotesApiCall))
            } else {
                result.postValue(CallResult.ResultError("Error"))
            }
        }
    }
}