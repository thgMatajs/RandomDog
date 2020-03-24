package com.gentalhacode.randomdog.domain.di

import com.gentalhacode.randomdog.domain.usecase.GetRandomDogUseCase
import org.koin.dsl.module

/**
 * .:.:.:. Created by @thgMatajs on 24/03/20 .:.:.:.
 */
val domainModule = module {
    factory { GetRandomDogUseCase(get()) }
}