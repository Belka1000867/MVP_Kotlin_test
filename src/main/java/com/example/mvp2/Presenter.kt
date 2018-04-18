package com.example.mvp2

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Oleg on 16/04/2018.
 * This class have to contain only java or Kotlin code
 */

class Presenter(private val view: MainActivity):IPresenter {
    //объекты для реализации mvp-паттерна
    private val db = DataBase()
    private val model= Model(db)
    var calendar:Calendar = Calendar.getInstance()        //класс для хранения даты
    val format = SimpleDateFormat("dd.MM.yyyy")           //класс для хранения инфы как представлять дату
    private var prices = model.getData(calendar)

    //блок инициализации экземпляра класса
    init{
        //setDateView in View (current day)
        var date_string = format.format(calendar.getTime())
        calendar.add(Calendar.DATE, -1)
        date_string = date_string + " - " + format.format(calendar.getTime())
        calendar.add(Calendar.DATE, 1)
        view.setDate(date_string)

        //setTable in View (current day)
        view.setTable(prices.getPrices())

        //setAveragePriceView in View (current day)
        val averagePrice = calculateAveragePrice(prices.getPrices())
        view.setAveragePrice(averagePrice)

        //setCurrentPriceView (price at 10 pm) in View (current day)
        val priceAt10pm =  calculatePrice(prices.getPrices())
        view.setCurrentPrice(priceAt10pm)
    }

    private fun calculateAveragePrice(data: IntArray): Int {
        var averagePrice = 0

        for (i in 0..data.size - 1) {
            averagePrice += data[i]
        }
        averagePrice /= data.size
        return averagePrice
    }

    private fun calculatePrice(data: IntArray): Int{
        return data[10]

    }

    override fun onNextButtonClick() {
        //setDateView in View (current day)
        var date_string = format.format(calendar.getTime())
        calendar.add(Calendar.DATE, 1)
        date_string = date_string + " - " + format.format(calendar.getTime())
        view.setDate(date_string)

        //load data from database
        prices = model.getData(calendar)
        //push data to View
        view.setTable(prices.getPrices())
        val averagePrice = calculateAveragePrice(prices.getPrices())
        view.setAveragePrice(averagePrice)
        val priceAt10pm =  calculatePrice(prices.getPrices())
        view.setCurrentPrice(priceAt10pm)
    }

    override fun onBackButtonClick() {

        calendar.add(Calendar.DATE, -2)
        var date_string = format.format(calendar.getTime())
        calendar.add(Calendar.DATE, 1)
        date_string = date_string + " - " + format.format(calendar.getTime())
        view.setDate(date_string)

        //push data to View
        view.setTable(prices.getPrices())
        val averagePrice = calculateAveragePrice(prices.getPrices())
        view.setAveragePrice(averagePrice)
        val priceAt10pm =  calculatePrice(prices.getPrices())
        view.setCurrentPrice(priceAt10pm)
    }
}