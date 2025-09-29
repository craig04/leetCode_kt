package cn_solution

private fun longestBalanced(s: String): Int {
    var ans = 0
    for (i in s.indices) {
        val cnt = IntArray(26)
        var cat = 0
        var max = 0
        for (len in 1..s.length - i) {
            val num = ++cnt[s[i + len - 1] - 'a']
            if (num == 1)
                cat++
            max = maxOf(max, num)
            if (max * cat == len)
                ans = maxOf(ans, len)
        }
    }
    return ans
}