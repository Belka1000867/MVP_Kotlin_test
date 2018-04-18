package com.example.mvp2

import java.util.*

/**
 * Created by Oleg on 16/04/2018.
 */
interface IModel {
    fun getData(date: Calendar): Prices_pojo
}