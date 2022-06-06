package com.example.mvvm_clean_arquitecture.learning.enum

class EnumClasses {

    init {
        enumClasses()
    }

    private fun enumClasses() {
        var userDirection: Direction? = null
        println("Direccion: $userDirection")

        userDirection = Direction.NORTH

    }

    enum class Direction(val dir: Int) {
        NORTH(1), SOUTH(-1), EAST(1), WEST(-1);

        fun description(): String {
            return if (this == NORTH){
                "ALLRIGHT"
            } else {
                "OH NO!"
            }
        }
    }
}