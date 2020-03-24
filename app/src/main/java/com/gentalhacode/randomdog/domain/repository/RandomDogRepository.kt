package com.gentalhacode.randomdog.domain.repository

import com.gentalhacode.randomdog.model.Dog

/**
 * .:.:.:. Created by @thgMatajs on 24/03/20 .:.:.:.
 */
interface RandomDogRepository {

    suspend fun getRandomDog(): Dog

}