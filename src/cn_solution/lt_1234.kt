package cn_solution

fun balancedString(s: String): Int {
    val n = s.length
    val m = s.length / 4
    val map = hashMapOf('Q' to 0, 'W' to 1, 'E' to 2, 'R' to 3)
    val rev = IntArray(4)
    val count = IntArray(4)
    var j = n - 1
    var result = n - 1
    s.forEach { count[map[it] ?: 0]++ }
    for (i in s.indices.reversed()) {
        while (j != -1) {
            if ((0..3).all { rev[it] + count[it] <= m })
                break
            --count[map[s[j--]] ?: 0]
        }
        result = minOf(result, i - j)
        if (++rev[map[s[i]] ?: 0] > m)
            break
    }
    return result
}