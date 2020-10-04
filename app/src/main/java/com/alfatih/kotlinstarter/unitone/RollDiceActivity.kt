package com.alfatih.kotlinstarter.unitone

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alfatih.kotlinstarter.R
import com.alfatih.kotlinstarter.databinding.ActivityRollDiceBinding

class RollDiceActivity : AppCompatActivity() {
    private lateinit var bindingRool: ActivityRollDiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingRool = DataBindingUtil.setContentView(
            this, R.layout.activity_roll_dice
        )

    }

    fun onRoll(view: View) {
        bindingRool.imgViewDice.setImageResource(getRandomDiceImage())
        bindingRool.imgViewDice2.setImageResource(getRandomDiceImage())

    }

    private fun getRandomDiceImage(): Int {
        val rnd = (1..6).random()
        val drawableResource = when (rnd) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }
}