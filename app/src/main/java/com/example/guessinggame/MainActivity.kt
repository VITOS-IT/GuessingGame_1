package com.example.guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val guessNumberView = findViewById<TextInputLayout>(R.id.guessInputView)
        val answerView = findViewById<TextView>(R.id.answerView)
        var secretNmber = Random.nextInt(0, 1000)
        findViewById<TextView>(R.id.checkBtn).setOnClickListener{
            val guessNumber = guessNumberView.editText?.text?.toString()?.toIntOrNull() ?:0

            if (secretNmber>guessNumber)
                answerView.text = "No, my number is bigger"
            else if (secretNmber<guessNumber)
                answerView.text = "No, my number is smaller"
            else
                answerView.text = "Yes, you are right!"
        }
        findViewById<TextView>(R.id.restartBtn).setOnClickListener{
            secretNmber = Random.nextInt(0, 1000)
            guessNumberView.editText?.setText("")
        }
    }
}

