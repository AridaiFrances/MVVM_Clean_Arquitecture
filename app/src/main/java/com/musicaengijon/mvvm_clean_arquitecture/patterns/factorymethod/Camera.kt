package com.musicaengijon.mvvm_clean_arquitecture.patterns.factorymethod

interface GenericCamera {
    fun open()
    fun takePicture()
    fun recordVideo()
    fun close()
}

class FirstCamera: GenericCamera {

    override fun open() {
        println("Opening FirstCamera")
    }

    override fun takePicture() {
        println("FirstCamera is taking a picture")
    }

    override fun recordVideo() {
        println("FirstCamera is recording video")
    }

    override fun close() {
        println("Closing FirstCamera")
    }
}

class SecondCamera: GenericCamera {

    override fun open() {
        println("Opening SecondCamera")
    }

    override fun takePicture() {
        println("SecondCamera is taking a picture")
    }

    override fun recordVideo() {
        println("SecondCamera is recording video")
    }

    override fun close() {
        println("Closing SecondCamera")
    }
}