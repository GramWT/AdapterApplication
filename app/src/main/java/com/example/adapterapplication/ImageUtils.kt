package com.example.adapterapplication

import android.graphics.Color
import kotlin.random.Random

object ImageUtils {
    fun getRandomColor(): Int {
        val random = Random.Default
        val red = random.nextInt(256)
        val green = random.nextInt(256)
        val blue = random.nextInt(256)
        return Color.rgb(red, green, blue)
    }
}