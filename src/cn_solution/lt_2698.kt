package cn_solution

fun punishmentNumber(n: Int): Int {
    fun punish(x: Int): Boolean {
        val s = (x * x).toString()
        fun dfs(i: Int, sum: Int): Boolean {
            if (i == s.length)
                return sum == 0
            var t = 0
            for (j in i until s.length) {
                t = s[j] - '0' + t * 10
                if (t > sum)
                    break
                else if (dfs(j + 1, sum - t))
                    return true
            }
            return false
        }
        return dfs(0, x)
    }
    return (1..n).asSequence().filter { punish(it) }.map { it * it }.sum()
}