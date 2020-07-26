package solution

import java.io.StringReader
import java.util.*

fun reformatDate(date: String): String {
    val map = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
            .withIndex()
            .associate { it.value to it.index + 1 }
    val sc = Scanner(StringReader(date))
    val day = sc.next().run {
        substring(0, indexOfFirst { it.isLetter() }).toInt()
    }
    val month = map[sc.next()]
    val year = sc.nextInt()
    return String.format("%d-%02d-%02d", year, month, day)
}