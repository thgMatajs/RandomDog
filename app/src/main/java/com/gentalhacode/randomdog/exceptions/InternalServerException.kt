package com.gentalhacode.randomdog.exceptions

import java.lang.Exception

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
class InternalServerException : Exception() {
    override val message: String = "Internal server error"
}