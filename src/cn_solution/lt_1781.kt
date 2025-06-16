package cn_solution

fun beautySum(s: String): Int {
    val cnt = IntArray(26)
    var ans = 0
    for (i in s.indices) {
        cnt.fill(0)
        for (j in i until s.length) {
            cnt[s[j] - 'a']++
            var min = Int.MAX_VALUE
            var max = Int.MIN_VALUE
            for (k in 0 until 26)
                if (cnt[k] != 0) {
                    min = minOf(min, cnt[k])
                    max = maxOf(max, cnt[k])
                }
            ans += max - min
        }
    }
    return ans
}