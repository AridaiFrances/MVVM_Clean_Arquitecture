package com.example.mvvm_clean_arquitecture.learning.anidadas

import kotlin.random.Random

class Anidadas {
    val one: Int = 1

    fun returnRandomNumber(): Int {
        return (0..10).random()
    }

    class NestedClass {
        fun returnSum(first: Int, second: Int = 2): Int {
            return first + second
        }
    }

    inner class InnerClass {
        private val two : Int = 2

        fun returnSum(digit: Int): Int {
            return digit + one + two + returnRandomNumber()
        }
    }
}