package com.gentalhacode.randomdog.domain.usecase

import com.gentalhacode.randomdog.domain.repository.RandomDogRepository
import com.gentalhacode.randomdog.model.Dog
import com.gentalhacode.randomdog.util.BaseUseCase

/**
 * .:.:.:. Created by @thgMatajs on 24/03/20 .:.:.:.
 */
class GetRandomDogUseCase(
    private val repository: RandomDogRepository
): BaseUseCase<Unit, Dog>() {

    override suspend fun buildUseCase(params: Unit?): Dog {
        return repository.getRandomDog()
    }
}