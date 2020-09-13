package com.alfatih.kotlinstarter.unitone

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alfatih.kotlinstarter.R

class InteractiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interactive)

    }

    fun setNickName(view: View) {
        val nickname_edit: EditText = findViewById(R.id.nickname_edit)
        val nickname_text: TextView = findViewById(R.id.nickname_text)
        val nickname = nickname_edit.text
        if (nickname.isNotEmpty()) {
            nickname_text.text = nickname
            nickname_text.visibility = View.VISIBLE
            var message = "Hello " + nickname
            showMessage(message)
        } else {
            showMessage("You do not any name!")
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