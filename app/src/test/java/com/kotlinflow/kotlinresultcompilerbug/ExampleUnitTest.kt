package com.kotlinflow.kotlinresultcompilerbug

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun testResult() {
        runBlocking {
            getA().zip(getB()) { a, b ->
                // Here, we are receiving wrapped kotlin.Result
                a to b
            }.collect {
                Log.d("", "")
            }
        }
    }

    fun getA(): Flow<Result<Boolean>> = flow {
        emit(Result.success(true))
    }

    fun getB(): Flow<Result<Boolean>> = flow {
        emit(Result.success(false))
    }
}