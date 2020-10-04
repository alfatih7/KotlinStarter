package com.alfatih.kotlinstarter.unitone.dessertclicker

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alfatih.kotlinstarter.R
import com.alfatih.kotlinstarter.databinding.ActivityDessertBinding
import timber.log.Timber

class DessertActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDessertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dessert)
        Timber.i("this on create callback")

        val dessertMainFragment = DessertMainFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view_dessert, dessertMainFragment)
            commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart Activity ")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Activity ")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart")
        Toast.makeText(applicationContext, "onRestart", Toast.LENGTH_SHORT).show()
    }
}
