package com.ddmukhin.onequote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ddmukhin.onequote.persistence.paper.PaperDatabase
import io.paperdb.Paper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}