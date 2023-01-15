package cn_solution

fun stoneGameII(piles: IntArray): Int {
    val n = piles.size
    val dp = HashMap<Int, Int>()
    val pre = IntArray(n + 1)
    piles.forEachIndexed { i, p -> pre[i + 1] = pre[i] + p }

    fun dfs(i: Int, m: Int): Int {
        return if (i == n) 0 else dp.getOrPut(i * 201 + m) {
            (1..minOf(2 * m, n - i)).fold(Int.MIN_VALUE) { res, j ->
                maxOf(res, pre[i + j] - pre[i] - dfs(i + j, maxOf(m, j)))
            }
        }
    }

    return (piles.sum() + dfs(0, 1)) / 2
}