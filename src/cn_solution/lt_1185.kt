package cn_solution

import java.time.LocalDate
import java.time.Month

fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
    val names = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return names[LocalDate.of(year, Month.of(month), day).dayOfWeek.ordinal]
}