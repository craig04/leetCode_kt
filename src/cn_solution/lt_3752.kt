package cn_solution

fun lexSmallestNegatedPerm(n: Int, target: Long): IntArray {
    val sum = (n + 1L) * n / 2
    if (target !in -sum..sum || (sum - target) % 2 != 0L)
        return intArrayOf()
    val ans = IntArray(n)
    var l = 0
    var r = ans.lastIndex
    var neg = (sum - target) / 2
    for (i in n downTo 1) {
        if (neg >= i) {
            ans[l++] = -i
            neg -= i
        } else {
            ans[r--] = i
        }
    }
    return ans
}