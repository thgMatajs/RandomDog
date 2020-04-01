package com.gentalhacode.randomdog.view.activities

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.Observer
import coil.api.load
import com.gentalhacode.randomdog.R
import com.gentalhacode.randomdog.util.NetworkUtils
import com.gentalhacode.randomdog.util.Status
import com.gentalhacode.randomdog.util.hide
import com.gentalhacode.randomdog.util.show
import com.gentalhacode.randomdog.view.viewmodel.RandomDogViewModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
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
    private val connectionNotifier: TextView by lazy {
        findViewById<TextView>(R.id.connectionNotifier)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeLiveData()
        observeNetworkConnectionLiveData()
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

    private fun observeNetworkConnectionLiveData() {
        NetworkUtils.getNetworkLiveData(this).observe(this, Observer {
            if (it) {
                connectionNotifier.hide()
            } else {
                connectionNotifier.show()
            }
        })
    }

    private fun showLoading() {
        progressBar.show()
        btnNewDog.hide()
        ivPhoto.hide()
    }

    private fun hideLoading() {
        progressBar.hide()
        btnNewDog.show()
        ivPhoto.show()
    }
}
