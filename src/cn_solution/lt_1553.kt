package cn_solution

fun minDays(n: Int): Int {
    val dp = hashMapOf(1 to 1, 2 to 2)
    fun dfs(x: Int): Int {
        return dp.getOrPut(x) {
            minOf(
                x % 2 + 1 + dfs(x / 2),
                x % 3 + 1 + dfs(x / 3)
            )
        }
    }
    return dfs(n)
}