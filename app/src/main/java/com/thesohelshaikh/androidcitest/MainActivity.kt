package com.thesohelshaikh.androidcitest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * This is the main entry point of the app.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * This is a test function to test kdoc.
     *
     * @param value String value to be tested.
     */
    private fun aTest(value: String) {
        /* no-op */
    }
}
