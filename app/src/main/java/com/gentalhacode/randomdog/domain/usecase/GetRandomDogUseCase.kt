package com.gentalhacode.randomdog.domain.usecase

import com.gentalhacode.randomdog.domain.repository.RandomDogRepository
import com.gentalhacode.randomdog.model.Dog

/**
 * .:.:.:. Created by @thgMatajs on 24/03/20 .:.:.:.
 */
class GetRandomDogUseCase(
    private val repository: RandomDogRepository
) {
    suspend fun execute(): Dog {
        return repository.getRandomDog()
    }
}