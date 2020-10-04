package com.alfatih.kotlinstarter.unitone.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alfatih.kotlinstarter.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        //set default frame contain the fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_fragment, firstFragment)
            commit()
        }
        button_fragment_one.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_fragment, firstFragment)
                addToBackStack(null)
                commit()
            }
        }
        button_fragment_two.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_fragment, secondFragment)
                //to back stack activity
                addToBackStack(null)
                commit()
            }
        }
    }
}