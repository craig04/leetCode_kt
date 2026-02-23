package cn_solution

private fun minFlips(s: String): Int {
    val n = s.length
    var cnt = s.indices.sumOf { it xor s[it].code and 1 }
    val ans = minOf(cnt, n - cnt)
    if (n and 1 == 0)
        return ans
    return (n until n * 2 - 1).fold(ans) { ans, j ->
        val i = j - n
        cnt -= i xor s[i].code and 1
        cnt += j xor s[i].code and 1
        minOf(ans, cnt, n - cnt)
    }
}