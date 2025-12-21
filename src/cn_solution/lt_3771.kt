package cn_solution

fun totalScore(hp: Int, damage: IntArray, requirement: IntArray): Long {
    val n = damage.size
    val suf = LongArray(n + 1)
    for (i in n - 1 downTo 0)
        suf[n - i] = suf[n - i - 1] + damage[i]
    var adj = 0L
    var res = 0L
    for (i in n - 1 downTo 0) {
        val req = hp - requirement[i] + adj
        var l = n - 1 - i
        var r = n
        while (l < r) {
            val m = (l + r + 1) / 2
            if (suf[m] > req)
                r = m - 1
            else
                l = m
        }
        res += l - (n - 1 - i)
        adj += damage[i]
    }
    return res
}