package cn_solution

fun maxDifference(s: String, k: Int): Int {
    var ans = Int.MIN_VALUE
    for (a in 0..4)
        for (b in 0..4) {
            if (a == b)
                continue
            val pre = IntArray(5)
            val cur = IntArray(5)
            val min = Array(2) { IntArray(2) { Int.MAX_VALUE / 2 } }
            var l = -1
            for (r in s.indices) {
                cur[s[r] - '0']++
                while (r - l >= k && cur[a] > pre[a] && cur[b] > pre[b]) {
                    val x = pre[a] and 1
                    val y = pre[b] and 1
                    min[x][y] = minOf(min[x][y], pre[a] - pre[b])
                    pre[s[++l] - '0']++
                }
                ans = maxOf(ans, cur[a] - cur[b] - min[cur[a] and 1 xor 1][cur[b] and 1])
            }
        }
    return ans
}