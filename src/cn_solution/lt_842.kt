package cn_solution

fun splitIntoFibonacci(num: String): List<Int> {
    val ans = ArrayList<Int>()
    fun dfs(start: Int): Boolean {
        if (start == num.length)
            return ans.size > 2
        var cur = 0
        var target = -1
        val n = ans.size
        if (n >= 2)
            target = ans[n - 1] + ans[n - 2]
        for (i in start until num.length) {
            val d = num[i] - '0'
            if (i != start && num[start] == '0' || (Int.MAX_VALUE - d) / 10 < cur)
                break
            cur = cur * 10 + d
            if (target == -1 || cur == target) {
                ans += cur
                if (dfs(i + 1))
                    return true
                ans.removeLast()
            } else if (cur > target)
                break
        }
        return false
    }
    dfs(0)
    return ans
}