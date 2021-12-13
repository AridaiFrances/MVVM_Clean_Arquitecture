package com.musicaengijon.mvvm_clean_arquitecture.patterns.factorymethod

class CustomButton(val diameter: Double) {

    companion object {
        fun withDiameter(diameter: Double) = CustomButton(diameter)
        fun withRatio(ratio: Double) = CustomButton(ratio*2)
    }
}