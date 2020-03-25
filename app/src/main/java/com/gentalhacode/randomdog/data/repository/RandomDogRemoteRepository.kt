package com.gentalhacode.randomdog.data.repository

import com.gentalhacode.randomdog.model.Dog

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
interface RandomDogRemoteRepository {
    suspend fun getRandomDog(): Dog
}