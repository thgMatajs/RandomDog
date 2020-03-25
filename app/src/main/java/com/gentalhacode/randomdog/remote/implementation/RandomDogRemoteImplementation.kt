package com.gentalhacode.randomdog.remote.implementation

import com.gentalhacode.randomdog.data.repository.RandomDogRemoteRepository
import com.gentalhacode.randomdog.model.Dog
import com.gentalhacode.randomdog.remote.service.RandomDogService

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
class RandomDogRemoteImplementation(
    private val service: RandomDogService
) : RandomDogRemoteRepository {

    override suspend fun getRandomDog(): Dog {
        return service.get()
    }
}