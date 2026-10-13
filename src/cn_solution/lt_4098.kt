package cn_solution

fun minimumMaxValue(n: Int, index: Int, value: Int): Long {
    if (value == 1)
        return -1
    var x = 2
    while (x * x <= value && value % x != 0)
        x++
    if (value % x != 0)
        x = value
    if (value - 2 * index - x + 2 <= 0)
        return -1
    return value + (n - index) * 2L + x - 4
}