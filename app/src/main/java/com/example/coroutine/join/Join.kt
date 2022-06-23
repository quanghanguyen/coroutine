package com.example.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
    val job = GlobalScope.launch {
        delay(5000L)
        println("Chờ để in dòng này")
    }
    println("Hello,")
    job.join()
    println("End")
}