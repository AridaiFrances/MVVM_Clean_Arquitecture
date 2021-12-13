package com.musicaengijon.mvvm_clean_arquitecture.patterns.structural.facade

import android.graphics.Bitmap

class Filter {

    val imageProcessor = ImageProcessor()

    fun balckAndWhiteTransform(image:Bitmap): Bitmap {
        val transformedImage = imageProcessor.edgeDetection(image)
        return imageProcessor.convolution(transformedImage)
    }

    fun applyRetroFilter(image: Bitmap): Bitmap {
        TODO()
    }
}