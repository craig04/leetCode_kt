package cn_solution

fun sellingWood(m: Int, n: Int, prices: Array<IntArray>): Long {
    val dp = hashMapOf(0 to 0L)
    val options = prices.associateTo(HashMap()) { (h, w, p) -> h shl 10 or w to p.toLong() }
    fun dfs(h: Int, w: Int): Long {
        val key = h shl 10 or w
        return dp.getOrPut(key) {
            maxOf(
                options[key] ?: 0,
                (1 until h).maxOfOrNull { dfs(it, w) + dfs(h - it, w) } ?: 0,
                (1 until w).maxOfOrNull { dfs(h, it) + dfs(h, w - it) } ?: 0
            )
        }
    }
    return dfs(m, n)
}