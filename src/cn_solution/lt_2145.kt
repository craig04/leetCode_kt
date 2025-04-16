package cn_solution

fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
    var cur = 0
    var min = 0
    var max = 0
    val gap = upper - lower
    for (diff in differences) {
        cur += diff
        min = minOf(min, cur)
        max = maxOf(max, cur)
        if (max - min > gap)
            return 0
    }
    return gap - max + min + 1
}