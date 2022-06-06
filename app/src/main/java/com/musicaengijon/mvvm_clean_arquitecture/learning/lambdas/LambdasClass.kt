package com.musicaengijon.mvvm_clean_arquitecture.learning.lambdas

import kotlin.concurrent.thread

class LambdasClass {

    val myIntList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val mySumFun = fun(x: Int, y: Int): Int = x + y
    val myMulFun = fun(x: Int, y: Int): Int = x * y
    val myFunX5 = fun (x: Int): Int = x * 5

    private fun myOperateFun(x: Int, y: Int, myFun: (Int, Int) -> Int): Int {
        return myFun(x, y)
    }

    private fun myMultFunX5(x: Int, myNewFun: (Int) -> Int): Int {
        return myNewFun(x)
    }


    //Callback
    private fun myAsincFun(name: String, hello:(String) -> Unit){
        val myNewString = "Hello $name"
        thread {
            Thread.sleep(5000)
            hello(myNewString)
        }

    }

    init {
        val myFilter = myIntList.filter {
            if (it == 1) {
                return@filter true
            }
            it > 5
        }

        println(myOperateFun(5, 10, mySumFun))

        myOperateFun(5, 10) { x, y -> x - y }

        myMultFunX5(5){ product ->
            5 * product

        }

        myAsincFun("User"){
            println(it)
        }

        CallbackExample.getCount({
            print(it.toString())
        }, {
            print(it.message)
        })
    }

    object CallbackExample {

        fun getCount(success: (count: Int) -> Unit, failed: (e: Error) -> Unit) {
            // Do something
            try {
                val a = 3
                success(a)
            } catch (e: Error) {
                failed(e)
            }
        }
    }
}