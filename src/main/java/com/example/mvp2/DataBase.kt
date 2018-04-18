package com.example.mvp2

import java.util.Random

class DataBase{

    internal fun getData(): IntArray {
        //реализую метод, который возвращат массив данных в формате int;

        //для примера верну массив интов от 3 до 20, за 48 часов (2-е суток)
        val random = Random()
        val result = IntArray(48)
        for (i in 0..47) {
            result[i] = random.nextInt(18) + 3
        }
        return result
    }
}