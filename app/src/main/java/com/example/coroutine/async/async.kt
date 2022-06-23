package com.example.coroutine.callmultipleAPI

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val totalTime = measureTimeMillis {
        val apiOne = async { printOne() }
        val apiTwo = async { printTwo() }
        println("Kết quả: ${apiOne.await() + apiTwo.await()}")
    }
    println("Tổng thời gian $totalTime ms")
}

suspend fun printOne(): Int {
    delay(1000)
    return 10
}

suspend fun printTwo(): Int {
    delay(1000)
    return 20
}
