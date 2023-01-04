package com.thesohelshaikh.androidcitest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val a = 10
        setContentView(R.layout.activity_main)
    }
}
