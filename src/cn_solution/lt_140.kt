package cn_solution

private fun wordBreak(s: String, wordDict: List<String>): List<String> {
    val n = s.length
    val dict = wordDict.indices.associateBy { wordDict[it] }
    val dp = Array<ArrayList<List<Int>>?>(n + 1) { null }
    dp[n] = arrayListOf(listOf())
    fun dfs(i: Int): ArrayList<List<Int>> {
        val ans = dp[i] ?: run {
            val list = ArrayList<List<Int>>()
            for (j in i + 1..n) {
                val idx = dict[s.substring(i, j)] ?: continue
                dfs(j).mapTo(list) { arrayListOf(idx).apply { addAll(it) } }
            }
            list
        }
        dp[i] = ans
        return ans
    }
    return dfs(0).map { it.joinToString(" ") { i -> wordDict[i] } }
}