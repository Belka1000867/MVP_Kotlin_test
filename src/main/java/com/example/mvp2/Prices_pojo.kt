package com.example.mvp2

/**
 * Created by Oleg on 18/04/2018.
 * class for storing data
 */
class Prices_pojo (private var prices: IntArray) {

    fun getPrices(): IntArray {
        return prices
    }

    fun setPrices(prices: IntArray) {
        this.prices = prices
    }

}