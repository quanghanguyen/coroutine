package com.example.coroutine.callAPI.model

import com.example.coroutine.callAPI.model.Result

data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)