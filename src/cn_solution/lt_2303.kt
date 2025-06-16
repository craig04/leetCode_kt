package cn_solution

fun calculateTax(brackets: Array<IntArray>, income: Int): Double {
    var ans = 0.0
    var pre = 0
    for (i in brackets.indices) {
        val (upper, percent) = brackets[i]
        ans += (minOf(income, upper) - pre) * percent / 100.0
        if (income <= upper)
            break
        pre = upper
    }
    return ans
}