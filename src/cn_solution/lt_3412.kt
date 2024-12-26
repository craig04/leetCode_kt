package cn_solution

fun calculateScore(s: String): Long {
    val pos = Array(26) { ArrayList<Int>() }
    var ans = 0L
    for (i in s.indices) {
        val t = s[i] - 'a'
        if (pos[25 - t].isNotEmpty())
            ans += i - pos[25 - t].removeLast()
        else
            pos[t].add(i)
    }
    return ans
}