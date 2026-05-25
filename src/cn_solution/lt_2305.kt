package cn_solution

fun distributeCookies(cookies: IntArray, k: Int): Int {
    val n = cookies.size
    var ans = Int.MAX_VALUE
    fun dfs(i: Int, left: Int, max: Int) {
        if (i == k) {
            if (left == 0)
                ans = minOf(ans, max)
            return
        }
        var x = left
        while (x != 0) {
            if (k - i - 1 <= left.xor(x).countOneBits()) {
                var sum = 0
                for (t in 0 until n)
                    if (1.shl(t).and(x) != 0)
                        sum += cookies[t]
                dfs(i + 1, left.xor(x), maxOf(max, sum))
            }
            x = (x - 1) and left
        }
    }
    dfs(0, 1.shl(n) - 1, 0)
    return ans
}