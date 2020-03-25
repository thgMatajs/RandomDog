package com.gentalhacode.randomdog.view.di

import com.gentalhacode.randomdog.view.viewmodel.RandomDogViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
val viewModeule = module(override = true) {
    viewModel { RandomDogViewModel(get()) }
}