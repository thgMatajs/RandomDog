package com.gentalhacode.randomdog.exceptions

import java.net.UnknownHostException

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
class WithoutConnectionException : UnknownHostException() {
    override val message: String = "Dispositivo sem conexão."
}