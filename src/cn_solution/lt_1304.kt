package cn_solution

fun sumZero(n: Int): IntArray {
    val ans = IntArray(n)
    for (i in 1 until n step 2) {
        ans[i - 1] = i / 2 + 1
        ans[i] = -ans[i - 1]
    }
    return ans
}