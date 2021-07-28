package com.damedane.diceroller

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.damedane.diceroller.GlobalColor.Companion.list
import com.damedane.diceroller.GlobalColor.Companion.selectedColor
import com.damedane.diceroller.R as R1


/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class Dice (private var numSides: Int) {

   fun create(): Int {
       val randomInt = (1..numSides).random()
       return when(selectedColor){
           "Blue" -> {
               when(randomInt){
                   1 -> R1.drawable.blu_dice_1
                   2 -> R1.drawable.blu_dice_2
                   3 -> R1.drawable.blu_dice_3
                   4 -> R1.drawable.blu_dice_4
                   5 -> R1.drawable.blu_dice_5
                   else -> R1.drawable.blu_dice_6
               }
           }
           "Green" ->{
               when(randomInt){
                   1 -> R1.drawable.green_dice_1
                   2 -> R1.drawable.green_dice_2
                   3 -> R1.drawable.green_dice_3
                   4 -> R1.drawable.green_dice_4
                   5 -> R1.drawable.green_dice_5
                   else -> R1.drawable.green_dice_6
               }
           }
           "Black" ->{
               when(randomInt){
                   1 -> R1.drawable.black_dice_1
                   2 -> R1.drawable.black_dice_2
                   3 -> R1.drawable.black_dice_3
                   4 -> R1.drawable.black_dice_4
                   5 -> R1.drawable.black_dice_5
                   else -> R1.drawable.black_dice_6
               }
           }
           else ->{
               when(randomInt){
                   1 -> R1.drawable.dice_1
                   2 -> R1.drawable.dice_2
                   3 -> R1.drawable.dice_3
                   4 -> R1.drawable.dice_4
                   5 -> R1.drawable.dice_5
                   else -> R1.drawable.dice_6
               }
           }
       }
   }
}

class MainActivity() : AppCompatActivity() {

    //Dice Object assignment, and screenView Updater
    private fun rollDice() {
        val dice = Dice(6)//Sides Assignment
        //val diceRoll = dice.roll() //roll Method Calling
        val drawR = dice.create()
        val diceImage: ImageView = findViewById(R1.id.imageView)//Find imageview and assign it

        //case or in kotlin when dice rolled => method gives img to ImageView
        /*val drawableResource = when (diceRoll) {
            1 -> R1.drawable.dice_1
            2 -> R1.drawable.dice_2
            3 -> R1.drawable.dice_3
            4 -> R1.drawable.dice_4
            5 -> R1.drawable.dice_5
            else -> R1.drawable.dice_6
        }*/

        diceImage.setImageResource(drawR)//assigns drawable from dice instance
        //diceImage.contentDescription = diceRoll.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R1.layout.activity_main)

        //References
        val rollButton: Button = findViewById(R1.id.button)
        val spinner: Spinner = findViewById(R1.id.spinner)
        //val list = mutableListOf("Red", "Blue", "Green", "Black")//using mutablelist
        //val textView: TextView = findViewById(R1.id.textView)
        //private var itemlist = arrayOf() ~using the arrayOf func for liszt

        val adapter = ArrayAdapter(this, R1.layout.spinner_list, list)
        adapter.setDropDownViewResource(R1.layout.support_simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val color: String = list[position]
                //Snackbar.make(this@MainActivity, "$item Dice selected", Toast.LENGTH_SHORT).show()
                Toast.makeText(this@MainActivity, "$color Dice selected", Toast.LENGTH_SHORT).show()

                // Add selected item to selectedColor variable above
                selectedColor = list.get(position)
                rollDice()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {/*if nothing is selected*/}

        }

        //testing the selectedColor
        //textView.text = selectedColor

        //Click and OnItem Listener
        rollButton.setOnClickListener { //This is for the button
            rollDice()
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        }

        rollDice()
    }
}






