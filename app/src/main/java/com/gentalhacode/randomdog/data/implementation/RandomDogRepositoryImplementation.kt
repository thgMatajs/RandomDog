package com.gentalhacode.randomdog.data.implementation

import com.gentalhacode.randomdog.data.repository.RandomDogRemoteRepository
import com.gentalhacode.randomdog.domain.repository.RandomDogRepository
import com.gentalhacode.randomdog.model.Dog

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
class RandomDogRepositoryImplementation(
    private val remote: RandomDogRemoteRepository
) : RandomDogRepository {

    override suspend fun getRandomDog(): Dog {
        var response = remote.getRandomDog()
        while (!response.photoUrl.endsWith(".mp4")) {
            response = remote.getRandomDog()
        }
        return response
    }
}