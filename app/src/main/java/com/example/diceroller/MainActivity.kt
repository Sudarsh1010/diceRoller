package com.example.diceroller

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    
//    setting up to roll dice on click event
    val rollButton: Button = findViewById(R.id.button)
    rollButton.setOnClickListener { rollDice() }
    
//    Do a dice roll when the app starts
    rollDice()
  }
  
  @SuppressLint("SetTextI18n")
  private fun rollDice() {
    val dice = Dice(6) // declaring dice val with 6.numSides
    
    // declaring diceRoll with value of dice to call roll() function
    val diceRoll1 = dice.roll()
    val diceRoll2 = dice.roll()

//    to display result on screen
    val diceImage1: ImageView = findViewById(R.id.imageView4)
    val diceImage2: ImageView = findViewById(R.id.imageView5)
    
    val drawable1 = when (diceRoll1) { // adding conditional to display different message
      1 -> R.drawable.dice_1
      2 -> R.drawable.dice_2
      3 -> R.drawable.dice_3
      4 -> R.drawable.dice_4
      5 -> R.drawable.dice_5
      else -> R.drawable.dice_6
    }
    val drawable2 = when (diceRoll2) { // adding conditional to display different message
      1 -> R.drawable.dice_1
      2 -> R.drawable.dice_2
      3 -> R.drawable.dice_3
      4 -> R.drawable.dice_4
      5 -> R.drawable.dice_5
      else -> R.drawable.dice_6
    }
    
//    Setting up result Images to display on screen
    diceImage1.setImageResource(drawable1)
    diceImage2.setImageResource(drawable2)
    
//    Content description
    diceImage1.contentDescription = diceRoll1.toString()
    diceImage2.contentDescription = diceRoll2.toString()
  }
  
//  function behind dice logic
  class Dice(private val numSides: Int) {
    fun roll(): Int {
      return (1..numSides).random()
    }
  }
}