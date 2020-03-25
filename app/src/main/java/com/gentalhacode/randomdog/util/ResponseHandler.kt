package com.gentalhacode.randomdog.util

import com.gentalhacode.randomdog.exceptions.InternalServerException
import com.gentalhacode.randomdog.exceptions.NotFoundException
import com.gentalhacode.randomdog.exceptions.TimeOutException
import com.gentalhacode.randomdog.exceptions.WithoutConnectionException
import retrofit2.HttpException
import java.lang.Exception
import java.net.UnknownHostException

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */

enum class ErrorCodes(val code: Int) {
    SocketTimeOut(-1)
}

open class ResponseHandler {

    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: Exception): Resource<T> {
        return when (e) {
            is HttpException -> {
                val httpException = getHttpException(e.code())
                Resource.error(httpException.message ?: "", httpException)
            }
            is UnknownHostException -> {
                Resource.error(
                    WithoutConnectionException().message,
                    WithoutConnectionException()
                )
            }
            else -> {
                Resource.error(e.message ?: "", e)
            }
        }
    }

    private fun getHttpException(code: Int): Exception {
        return when (code) {
            ErrorCodes.SocketTimeOut.code -> TimeOutException()
            404 -> NotFoundException()
            500 -> InternalServerException()
            else -> Exception()
        }
    }
}