package com.gentalhacode.randomdog.remote.di

import com.gentalhacode.randomdog.data.repository.RandomDogRemoteRepository
import com.gentalhacode.randomdog.remote.implementation.RandomDogRemoteImplementation
import com.gentalhacode.randomdog.remote.retrofit.RetrofitBuilder
import com.gentalhacode.randomdog.remote.service.RandomDogService
import org.koin.dsl.module

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
val remoteModule = module(override = true) {
    single {
        RetrofitBuilder().invoke<RandomDogService>("https://random.dog/")
    }
    factory<RandomDogRemoteRepository> { RandomDogRemoteImplementation(get()) }
}