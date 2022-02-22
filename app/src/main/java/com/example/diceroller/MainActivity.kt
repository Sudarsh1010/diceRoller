package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    
//    setting up to roll dice on click event
    val rollButton: Button = findViewById(R.id.button)
    rollButton.setOnClickListener { rollDice() }
  }
  
  private fun rollDice() {
    val dice = Dice(6) // declaring dice val with 6.numSides
    val diceRoll = dice.roll() // declaring diceRoll with value of dice to call roll() function
    
//    to display result on screen
    val resultTextView: TextView = findViewById(R.id.textView)
    resultTextView.text = diceRoll.toString()
  }
  
//  function behind dice logic
  class Dice(private val numSides: Int) {
    fun roll(): Int {
      return (1..numSides).random()
    }
  }
}