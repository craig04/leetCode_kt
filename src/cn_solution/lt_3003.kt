package cn_solution

fun maxPartitionsAfterOperations(s: String, k: Int): Int {
    val dp = HashMap<Long, Int>()
    fun dfs(i: Int, mask: Int, modified: Int): Int {
        if (i == s.length)
            return 1
        val key = (mask + 0L).shl(32) + i.shl(1) + modified
        return dp.getOrPut(key) {
            fun move(c: Char, modified: Int): Int {
                val bit = 1.shl(c - 'a')
                return if (mask.or(bit).countOneBits() > k)
                    1 + dfs(i + 1, bit, modified)
                else
                    dfs(i + 1, mask.or(bit), modified)
            }

            var res = move(s[i], modified)
            if (modified == 0) {
                for (c in 'a'..'z') {
                    if (c == s[i])
                        continue
                    res = maxOf(res, move(c, 1))
                }
            }
            res
        }
    }
    return dfs(0, 0, 0)
}