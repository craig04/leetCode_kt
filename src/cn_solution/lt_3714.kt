package cn_solution

private fun longestBalanced(s: String): Int {
    val n = s.length
    var ans = 0
    fun single() {
        var i = 0
        while (i != n) {
            var j = i + 1
            while (j != n && s[j] == s[i])
                j++
            ans = maxOf(ans, j - i)
            i = j
        }
    }

    fun double(x: Char, y: Char) {
        var i = 0
        while (i < n) {
            val map = hashMapOf(0 to i - 1)
            var d = 0
            while (i != n && (s[i] == x || s[i] == y)) {
                if (s[i] == x) d++ else d--
                val j = map.putIfAbsent(d, i)
                if (j != null)
                    ans = maxOf(ans, i - j)
                i++
            }
            i++
        }
    }

    fun triple() {
        val m = n + 0L
        val map = hashMapOf(m.shl(32).or(m) to -1)
        val cnt = IntArray(3)
        for (i in s.indices) {
            cnt[s[i] - 'a']++
            val x = cnt[0] - cnt[1] + m
            val y = cnt[0] - cnt[2] + m
            val j = map.putIfAbsent(x.shl(32).or(y), i)
            if (j != null)
                ans = maxOf(ans, i - j)
        }
    }

    single()
    double('a', 'b')
    double('b', 'c')
    double('c', 'a')
    triple()
    return ans
}