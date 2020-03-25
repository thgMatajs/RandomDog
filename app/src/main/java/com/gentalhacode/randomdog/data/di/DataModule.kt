package com.gentalhacode.randomdog.data.di

import com.gentalhacode.randomdog.data.implementation.RandomDogRepositoryImplementation
import com.gentalhacode.randomdog.domain.repository.RandomDogRepository
import org.koin.dsl.module

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
val dataModule = module(override = true) {
    factory<RandomDogRepository> { RandomDogRepositoryImplementation(get()) }
}