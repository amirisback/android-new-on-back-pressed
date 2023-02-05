package com.frogobox.research.core

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Faisal Amir on 24/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */

abstract class BaseActivity : AppCompatActivity() {

    open fun doOnBackPressedExt() {
        Log.d(BaseActivity::class.java.simpleName, "doOnBackPressedExt: From Parent")
        finish()
    }

    open fun onBackPressedExt() {
        Log.d(BaseActivity::class.java.simpleName, "onBackPressedExt: From Parent")
        onBackPressedDispatcher.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDoOnBackPressedExt()
    }

    private fun setupDoOnBackPressedExt() {
        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher.registerOnBackInvokedCallback(OnBackInvokedDispatcher.PRIORITY_DEFAULT) {
                // Back is pressed... Finishing the activity
                Log.d(BaseActivity::class.java.simpleName, "Build >= 33")
                Log.d(BaseActivity::class.java.simpleName, "Back is pressed... Finishing the activity")
                doOnBackPressedExt()
            }
        } else {
            onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Back is pressed... Finishing the activity
                    Log.d(BaseActivity::class.java.simpleName, "Back is pressed... Finishing the activity")
                    doOnBackPressedExt()
                }
            })
        }
    }

}