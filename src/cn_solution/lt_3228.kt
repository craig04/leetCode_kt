package cn_solution

private fun maxOperations(s: String): Int {
    var ans = 0
    var cnt = 0
    for (i in 0 until s.lastIndex)
        if (s[i] != '0') {
            cnt++
            if (s[i + 1] == '0')
                ans += cnt
        }
    return ans
}