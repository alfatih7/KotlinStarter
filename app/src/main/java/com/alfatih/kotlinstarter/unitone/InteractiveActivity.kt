package com.alfatih.kotlinstarter.unitone

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alfatih.kotlinstarter.R
import com.alfatih.kotlinstarter.databinding.ActivityInteractiveBinding
import com.alfatih.kotlinstarter.unitone.basic.MyDataNam

class InteractiveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInteractiveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_interactive)


    }

    fun setNickName(view: View) {
        val myName: MyDataNam = MyDataNam()
        binding.myName = myName

        val nickname_edit = binding.nicknameEdit
        val nickname_text = binding.nicknameText
        val nickname = nickname_edit.text
        if (nickname.isNotEmpty()) {
            binding.apply {
                myName?.nickName = nickname_edit.text.toString()
                invalidateAll()
                nickname_text.visibility = View.VISIBLE

            }
            var message = "Hello " + nickname
            showMessage(message)
        } else {
            showMessage("You didn't enter a name!")
        }
        // Hide the keyboard.
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}