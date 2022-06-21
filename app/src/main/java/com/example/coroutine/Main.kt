package com.example.coroutine

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    val start = System.currentTimeMillis()
    runBlocking {
        repeat(1_000_000) {
            launch {
                println("Hi")
            }
        }
    }
    val end = System.currentTimeMillis()
    println("Thời gian chạy = ${end - start} ms")
}

