package com.frogobox.research.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.frogobox.research.core.BaseBindActivity
import com.frogobox.research.databinding.ActivityMainBinding
import com.frogobox.research.ui.detail.DetailActivity

class MainActivity : BaseBindActivity<ActivityMainBinding>() {

    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }

    private val viewModel: MainViewModel by viewModels()

    override fun initBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            // Call View Model Here
            Log.d(TAG, "View Model : ${viewModel::class.java.simpleName}")
        }
        // TODO : Add your code here

    }

    override fun initView() {
        super.initView()
        binding.apply {
            button.setOnClickListener {
                startActivity(Intent(this@MainActivity, DetailActivity::class.java))
            }
        }
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.apply {

        }
    }

}