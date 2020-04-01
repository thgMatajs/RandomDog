package com.gentalhacode.randomdog.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gentalhacode.randomdog.domain.usecase.GetRandomDogUseCase
import com.gentalhacode.randomdog.model.Dog
import com.gentalhacode.randomdog.util.Resource
import com.gentalhacode.randomdog.util.ResponseHandler
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
class RandomDogViewModel(
    private val getDogUseCase: GetRandomDogUseCase
) : ViewModel() {

    private val getDogLiveData: MutableLiveData<Resource<Dog>> = MutableLiveData()
    val observeGetDogLiveData: LiveData<Resource<Dog>>
        get() = getDogLiveData

    fun getDog() {
        getDogLiveData.postValue(Resource.loading())
        viewModelScope.launch(IO) {
            getDogUseCase.execute(null,
                onSuccess = {
                    getDogLiveData.postValue(ResponseHandler.handleSuccess(it))
                },
                onError = {
                    getDogLiveData.postValue(ResponseHandler.handleException(it))
                })
        }
    }
}