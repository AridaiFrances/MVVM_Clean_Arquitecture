package com.musicaengijon.mvvm_clean_arquitecture.patterns.structural.adapter

class MapHandler {
    val map: Map2Adapter = Map2Adapter()
    fun useMap() {
        map.goToPosition(Pair(0.5, 4.2))
        map.showRoute(listOf(Pair(0.5, 4.2), Pair(0.6, 4.2)))
        map.markArea(Pair(0.5, 4.2), Pair(0.6, 4.2))
    }
}