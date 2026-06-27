package cn_solution

fun secondsBetweenTimes(startTime: String, endTime: String): Int {
    val s = intArrayOf(36000, 3600, 0, 600, 60, 0, 10, 1)
    fun String.seconds() = indices.sumOf { (this[it] - '0') * s[it] }
    return endTime.seconds() - startTime.seconds()
}