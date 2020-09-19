package com.alfatih.kotlinstarter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alfatih.kotlinstarter.unitone.ConstrainActivity
import com.alfatih.kotlinstarter.unitone.InteractiveActivity
import com.alfatih.kotlinstarter.unitone.RollDiceActivity
import com.alfatih.kotlinstarter.unitone.basic.BasicActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_dice_btn);
        rollButton.setOnClickListener { openRoll() }

        findViewById<Button>(R.id.button_constrain).setOnClickListener {
            startActivity(Intent(this, ConstrainActivity::class.java))
        }

    }

    private fun openRoll() {
        val intent = Intent(this, RollDiceActivity::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        Toast.makeText(applicationContext, "on Start", Toast.LENGTH_SHORT).show()
        super.onStart()
    }

    fun openBasicActivity(view: View) {
        startActivity(Intent(this, BasicActivity::class.java))
    }

    fun openInteractive(view: View) {
        startActivity(Intent(this, InteractiveActivity::class.java))
    }


}