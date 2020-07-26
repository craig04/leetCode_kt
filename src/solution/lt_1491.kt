package solution

fun average(salary: IntArray): Double {
    var ave = 0
    var min = Integer.MAX_VALUE
    var max = Integer.MIN_VALUE
    salary.forEach {
        ave += it
        min = minOf(min, it)
        max = maxOf(max, it)
    }
    return (ave - min - max).toDouble() / (salary.size - 2)
}