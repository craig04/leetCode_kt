package cn_solution

fun sequentialDigits(low: Int, high: Int): List<Int> {
    val ans = arrayListOf<Int>()
    for (i in 1..9) {
        var x = i
        for (j in i + 1..9) {
            x = x * 10 + j
            if (x > high)
                break
            if (x >= low)
                ans += x
        }
    }
    ans.sort()
    return ans
}