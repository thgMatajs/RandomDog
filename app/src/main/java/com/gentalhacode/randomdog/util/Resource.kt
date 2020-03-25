package com.gentalhacode.randomdog.util

import java.lang.Exception

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?, val exception: Exception?) {
    companion object {

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, null, null)
        }

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null, null)
        }

        fun <T> error(msg: String, ex: Exception): Resource<T> {
            return Resource(Status.ERROR, null, msg, ex)
        }

    }
}

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}