package com.aeryz.hackathon3_groupd.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.aeryz.hackathon3_groupd.R

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateCountText()
    }

    fun onPlusButtonClick(view: View) {
        count++
        updateCountText()
    }


    fun onMinusButtonClick(view: View) {
        if (count > 0) {
            count--
            updateCountText()
        }
    }


    private fun updateCountText() {
        val countImageView = findViewById<ImageView>(R.id.countImageView)
        countImageView.contentDescription = "Jumlah: $count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onBuyNowButtonClick(view: View) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onBackImageViewClick(view: View) {
    }
}