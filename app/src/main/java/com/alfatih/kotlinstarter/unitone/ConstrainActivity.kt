package com.alfatih.kotlinstarter.unitone

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.alfatih.kotlinstarter.R
import com.alfatih.kotlinstarter.databinding.ActivityConstrainBinding

class ConstrainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConstrainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_constrain)

        val layoutparm = binding.boxThreeText.layoutParams as ConstraintLayout.LayoutParams
        layoutparm.setMargins(8, 0, 8, 8)

        setListeners()
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.CYAN)
            R.id.box_two_text -> view.setBackgroundColor(Color.YELLOW)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> view.setBackgroundColor(Color.GREEN)
            R.id.box_five_text -> view.setBackgroundColor(Color.RED)
            else -> view.setBackgroundColor(Color.LTGRAY)

        }

    }

    private fun setListeners() {

        val boxOneText = binding.boxOneText
        val boxTwoText = binding.boxTwoText
        val boxThreeText = binding.boxThreeText
        val boxFourText = binding.boxFourText
        val boxFiveText = binding.boxFiveText
        val rootConstraintLayout = binding.constraintLayout
        val btn_red = binding.redButton
        val btn_yel = binding.yellowButton
        val btn_grn = binding.greenButton

        val clickableViews: List<View> =
            listOf(
                boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout, btn_red, btn_grn, btn_yel
            )
        for (item in clickableViews) {
            if (item == btn_grn) {
                item.setOnClickListener { rootConstraintLayout.setBackgroundColor(Color.GREEN) }
            } else if (item == btn_red) {
                item.setOnClickListener { rootConstraintLayout.setBackgroundColor(Color.RED) }
            } else if (item == btn_yel) {
                item.setOnClickListener { rootConstraintLayout.setBackgroundColor(Color.YELLOW) }
            } else
                item.setOnClickListener { makeColored(it) }
        }

    }

}