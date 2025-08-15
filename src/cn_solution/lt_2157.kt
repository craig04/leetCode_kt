package cn_solution

fun groupStrings(words: Array<String>): IntArray {
    val map = HashMap<Int, Int>()
    for (word in words)
        map.merge(word.fold(0) { acc, c -> 1 shl (c - 'a') or acc }, 1, Int::plus)
    fun dfs(mask: Int): Int {
        var res = map.remove(mask) ?: return 0
        for (a in 0 until 26) {
            val one = 1 shl a xor mask
            res += dfs(one)
            if (one > mask)
                continue
            for (b in 0 until 26) {
                val two = 1 shl b xor one
                if (two > one && two != mask)
                    res += dfs(two)
            }
        }
        return res
    }

    val ans = IntArray(2)
    for (mask in ArrayList(map.keys)) {
        val res = dfs(mask)
        if (res != 0) {
            ans[0]++
            ans[1] = maxOf(ans[1], res)
        }
    }
    return ans
}