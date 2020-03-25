package com.gentalhacode.randomdog.util

import java.lang.Exception

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
abstract class BaseUseCase<in Params, T> {

    abstract suspend fun buildUseCase(params: Params? = null): T

    suspend fun execute(
        params: Params? = null,
        onSuccess: (T) -> Unit,
        onError: (ex: Exception) -> Unit
    ) {
        try {
            onSuccess.invoke(buildUseCase(params))
        } catch (e: Exception) {
            onError.invoke(e)
        }
    }
}