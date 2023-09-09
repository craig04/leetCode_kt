package cn_solution

fun splitNum(num: Int): Int {
    val digit = ArrayList<Int>()
    var temp = num
    var base = 1
    var result = 0
    do {
        val a = temp % 100
        digit.add(a / 10)
        digit.add(a % 10)
        temp /= 100
    } while (temp != 0)
    digit.sort()
    for (i in digit.lastIndex downTo 1 step 2) {
        result += (digit[i] + digit[i - 1]) * base
        base *= 10
    }
    return result
}