package com.gentalhacode.randomdog.exceptions

import java.lang.Exception

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
class TimeOutException : Exception() {
    override val message: String = "Time out"
}