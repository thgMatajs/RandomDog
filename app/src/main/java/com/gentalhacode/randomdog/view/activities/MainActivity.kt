package com.gentalhacode.randomdog.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.gentalhacode.randomdog.R
import com.gentalhacode.randomdog.util.Resource
import com.gentalhacode.randomdog.util.Status
import com.gentalhacode.randomdog.view.viewmodel.RandomDogViewModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val dogViewModel: RandomDogViewModel by viewModel()

    private val btnNewDog: ExtendedFloatingActionButton by lazy {
        findViewById<ExtendedFloatingActionButton>(R.id.btnNewDog)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeLiveData()
        initBtnActions()
    }

    private fun initBtnActions() {
        btnNewDog.setOnClickListener {
            CoroutineScope(IO).launch {
                dogViewModel.getDog()
            }
        }
    }

    private fun observeLiveData() {
        dogViewModel.observeGetDogLiveData.observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {
                    println("THG_LOADING")
                }
                Status.SUCCESS -> {
                    println("THG_SUCCESS ${it.data?.photoUrl}")
                }
                Status.ERROR -> {
                    println("THG_ERROR ${it.exception?.message}")
                }
            }
        })
    }
}
