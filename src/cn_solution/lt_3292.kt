package cn_solution

private fun minValidStrings(words: Array<String>, target: String): Int {
    val jumps = IntArray(target.length)
    for (word in words) {
        val s = "$word#$target".toCharArray()
        val z = IntArray(s.size)
        var l = 0
        var r = 0
        for (i in 1 until s.size) {
            if (i <= r)
                z[i] = minOf(z[i - l], r - i + 1)
            while (i + z[i] < s.size && s[i + z[i]] == s[z[i]])
                z[i]++
            if (i + z[i] - 1 > r) {
                l = i
                r = i + z[i] - 1
            }
        }
        for (i in target.indices)
            jumps[i] = maxOf(jumps[i], z[i + word.length + 1])
    }
    var ans = 0
    var pre = 0
    var cur = 0
    for (i in jumps.indices) {
        cur = maxOf(cur, i + jumps[i])
        if (pre == i) {
            if (pre == cur)
                return -1
            pre = cur
            ans++
        }
    }
    return ans
}