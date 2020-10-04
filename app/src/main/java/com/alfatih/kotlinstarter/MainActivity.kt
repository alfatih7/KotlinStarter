package com.alfatih.kotlinstarter

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alfatih.kotlinstarter.databinding.ActivityMainBinding
import com.alfatih.kotlinstarter.unitone.ConstrainActivity
import com.alfatih.kotlinstarter.unitone.InteractiveActivity
import com.alfatih.kotlinstarter.unitone.RollDiceActivity
import com.alfatih.kotlinstarter.unitone.basic.BasicActivity
import com.alfatih.kotlinstarter.unitone.dessertclicker.DessertActivity
import com.alfatih.kotlinstarter.unitone.navigation.MainNav

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val rollButton = binding.rollDiceBtn
        rollButton.setOnClickListener {
            startActivity(Intent(this, RollDiceActivity::class.java))
        }

        binding.buttonConstrain.setOnClickListener {
            startActivity(Intent(this, ConstrainActivity::class.java))
        }
        binding.buttonFragment.setOnClickListener {
            startActivity(Intent(this, MainNav::class.java))
        }
        binding.buttonDessert.setOnClickListener {
            startActivity(Intent(this, DessertActivity::class.java))
        }

    }


    fun openBasicActivity(view: View) {
        startActivity(Intent(this, BasicActivity::class.java))
    }

    fun openInteractive(view: View) {
        startActivity(Intent(this, InteractiveActivity::class.java))
    }


}