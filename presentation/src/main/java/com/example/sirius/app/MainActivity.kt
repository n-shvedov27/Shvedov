package com.example.sirius.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sirius.R
import com.example.sirius.fragment.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.host_fragment, MainFragment())
                .commit()
        }
    }
}