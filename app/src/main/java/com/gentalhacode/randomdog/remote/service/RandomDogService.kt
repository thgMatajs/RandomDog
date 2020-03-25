package com.gentalhacode.randomdog.remote.service

import com.gentalhacode.randomdog.remote.model.RemoteDog
import retrofit2.http.GET

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
interface RandomDogService {
    @GET("woof.json")
    suspend fun get(): RemoteDog
}