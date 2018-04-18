package com.example.mvp2

import java.util.Calendar

class Model(private val db: DataBase):IModel {

    override fun getData(date: Calendar): Prices_pojo {
        //метод записывает данные в pojo-класс из базы данных
        //но это не правда, так как базы данных нет
        //есть класс DataBase, который возвращает массив интов, который я записываю в pojo
        val prices:Prices_pojo = Prices_pojo(db.getData())
        return prices
    }
}