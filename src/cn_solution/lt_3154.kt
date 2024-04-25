package cn_solution

fun waysToReachStair(k: Int): Int {
    val c = Array(32) { IntArray(32) }
    c[0][0] = 1
    for (i in 1..31) {
        c[i][0] = 1
        for (j in 1..31)
            c[i][j] = c[i - 1][j - 1] + c[i - 1][j]
    }
    var result = 0
    for (j in 0 until 31) {
        val max = 1 shl j
        val min = max - j - 1
        if (k < min)
            break
        if (k > max)
            continue
        result += c[j + 1][k - min]
    }
    return result
}