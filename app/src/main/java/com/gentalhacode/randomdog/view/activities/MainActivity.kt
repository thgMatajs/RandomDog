package com.gentalhacode.randomdog.view.activities

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.Observer
import coil.api.load
import com.gentalhacode.randomdog.R
import com.gentalhacode.randomdog.util.Status
import com.gentalhacode.randomdog.view.viewmodel.RandomDogViewModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val dogViewModel: RandomDogViewModel by viewModel()

    private val btnNewDog: ExtendedFloatingActionButton by lazy {
        findViewById<ExtendedFloatingActionButton>(R.id.btnNewDog)
    }
    private val ivPhoto: AppCompatImageView by lazy {
        findViewById<AppCompatImageView>(R.id.ivPhoto)
    }
    private val progressBar: ProgressBar by lazy {
        findViewById<ProgressBar>(R.id.progressBar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeLiveData()
        initBtnActions()
    }

    private fun initBtnActions() {
        btnNewDog.setOnClickListener {
            dogViewModel.getDog()
        }
    }

    private fun observeLiveData() {
        dogViewModel.observeGetDogLiveData.observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {
                    println("THG_LOADING")
                    showLoading()
                }
                Status.SUCCESS -> {
                    println("THG_SUCCESS ${it.data?.photoUrl}")
                    ivPhoto.load(it.data?.photoUrl)
                    hideLoading()
                }
                Status.ERROR -> {
                    println("THG_ERROR ${it.exception?.message}")
                    hideLoading()
                    Toast.makeText(this, it.exception?.message ?: "", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
        btnNewDog.visibility = View.GONE
        ivPhoto.visibility = View.GONE
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
        btnNewDog.visibility = View.VISIBLE
        ivPhoto.visibility = View.VISIBLE
    }
}
