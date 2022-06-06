package com.example.mvvm_clean_arquitecture.learning.alias

        typealias MyMapList = MutableMap<Int, List<String>>
        typealias MyFun = (Int, String, MyMapList) -> Boolean

class TypeAliasClass {

    private var myMap: MyMapList = mutableMapOf()

    private fun typeAliases() {
        var myNewMap: MyMapList = mutableMapOf()

        myNewMap[1] = listOf("First", "Second")
        myNewMap[2] = listOf("Third", "Fourth")

        myMap = myNewMap
    }



}