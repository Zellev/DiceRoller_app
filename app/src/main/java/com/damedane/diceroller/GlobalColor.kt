package com.damedane.diceroller

import android.app.Application

class GlobalColor: Application() {
    companion object {
        val list = mutableListOf("Red", "Blue", "Green", "Black")//using mutablelist
        var selectedColor = list.get(0)//for when color spinner returning a value
    }

}
