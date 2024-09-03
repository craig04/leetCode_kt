package cn_solution

fun convertDateToBinary(date: String): String {
    val t = intArrayOf(0, 4, 5, 7, 8, 10)
    return t.indices.step(2).joinToString("-") {
        date.substring(t[it], t[it + 1]).toInt().toString(2)
    }
}