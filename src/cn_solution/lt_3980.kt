package cn_solution

private fun minOperations(s1: String, s2: String): Int {
    if (s1.length == 1 && s1[0] - s2[0] == 1)
        return -1
    var ans = 0
    var modify = false
    for (i in s1.indices) {
        val a = if (modify) '0' else s1[i]
        modify = false
        when {
            a == s2[i] -> continue
            a == '0' -> ans++
            i == s1.lastIndex || s1[i + 1] == '0' -> ans += 2
            else -> {
                ans++
                modify = true
            }
        }
    }
    return ans
}