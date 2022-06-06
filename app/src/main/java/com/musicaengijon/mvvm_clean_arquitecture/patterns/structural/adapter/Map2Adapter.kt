package com.musicaengijon.mvvm_clean_arquitecture.patterns.structural.adapter

import android.graphics.Color

class Map2Adapter {
    val map2: Map2 = Map2()

    fun showRoute(points: List<Pair<Double, Double>>) {
    map2.showRouteOnMap(points.map { it.toLocation() }, Color.BLUE)
    }
    fun goToPosition(point: Pair<Double, Double>) {
    map2.goToPosition(point.toLocation(),10.0)
    }
    fun markArea(topLeft: Pair<Double, Double>, bottomRight: Pair<Double, Double>) {

    }
}