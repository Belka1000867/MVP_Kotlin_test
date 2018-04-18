package com.example.mvp2

/**
 * Created by Oleg on 16/04/2018.
 */
interface IView {
    fun setCurrentPrice(current: Int)
    fun setAveragePrice(average: Int)
    fun setDate(date: String)
    fun setTable(data: IntArray)
}