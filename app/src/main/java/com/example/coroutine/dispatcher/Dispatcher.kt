package com.example.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {

    launch(Dispatchers.Default) {

        // Thường được dùng khi sorting List, Parse Json
        // tương đương với GlobalScope.launch (Dispatchers.Default + Job()) { }
        println("Default: Đang chạy trên ${Thread.currentThread().name}")
    }

    launch(Dispatchers.IO) {

        // Thường được dùng khi Read hoặc Write Files, Database
        println("IO: Đang chạy trên ${Thread.currentThread().name}")
    }

    launch(newSingleThreadContext("MyOwnThread")) {

        // Thread do mình tự đặt tên
        println("MyOwnThread: Đang chạy trên ${Thread.currentThread().name}")
    }
}