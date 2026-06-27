package cn_solution

fun maxUniqueSplit(s: String): Int {
    val set = HashSet<String>()
    var ans = 0
    fun dfs(curr: Int) {
        if (curr == s.length) {
            ans = maxOf(ans, set.size)
            return
        }
        for (next in curr + 1..s.length) {
            val substr = s.substring(curr, next)
            if (set.add(substr)) {
                dfs(next)
                set -= substr
            }
        }
    }
    dfs(0)
    return ans
}