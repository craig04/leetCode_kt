package cn_solution

private fun longestBalanced(s: String): Int {
    val cnt1 = s.sumOf { it - '0' }
    val cnt0 = s.length - cnt1
    val map = hashMapOf(0 to arrayListOf(-1))
    var sum = 0
    var ans = 0
    for (i in s.indices) {
        sum += (s[i] - '0') * 2 - 1
        var pre = map[sum]
        if (pre != null)
            ans = maxOf(ans, i - pre[0])
        pre = map[sum - 2]
        if (pre != null) {
            if ((i - pre[0]) / 2 - 1 < cnt0)
                ans = maxOf(ans, i - pre[0])
            else if (pre.size == 2)
                ans = maxOf(ans, i - pre[1])
        }
        pre = map[sum + 2]
        if (pre != null) {
            if ((i - pre[0]) / 2 - 1 < cnt1)
                ans = maxOf(ans, i - pre[0])
            else if (pre.size == 2)
                ans = maxOf(ans, i - pre[1])
        }
        pre = map.computeIfAbsent(sum) { ArrayList() }
        if (pre.size < 2)
            pre.add(i)
    }
    return ans
}