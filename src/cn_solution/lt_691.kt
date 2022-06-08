package cn_solution

fun minStickers(stickers: Array<String>, target: String): Int {
    val m = target.length
    val dp = IntArray(1 shl m) { -1 }
    dp[0] = 0
    fun dfs(bits: Int): Int {
        if (dp[bits] == -1) {
            var result = Int.MAX_VALUE
            for (cs in stickers) {
                val count = IntArray(26)
                var removed = 0
                for (c in cs) count[c - 'a']++
                for (i in 0 until m) {
                    val bit = 1 shl i
                    if (bit and bits != 0 && --count[target[i] - 'a'] >= 0)
                        removed = removed or bit
                }
                if (removed != 0) {
                    val temp = dfs(bits xor removed)
                    if (temp != Int.MAX_VALUE) result = minOf(result, temp + 1)
                }
            }
            dp[bits] = result
        }
        return dp[bits]
    }

    val result = dfs(1.shl(m) - 1)
    return if (result == Int.MAX_VALUE) -1 else result
}