package com.example.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//-------------------------------------------------------------------------------

private fun main() {
    val start = System.currentTimeMillis()
    runBlocking {
        repeat(1_000_000) {
            launch {
                println("Xin chào")
            }
        }
    }
    val end = System.currentTimeMillis()
    println("Thời gian chạy = ${end - start} ms")
}

// ------------------------------------------------------------------------------

