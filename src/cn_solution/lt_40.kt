package cn_solution

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val temp = ArrayList<Int>()
    val count = HashMap<Int, Int>()
    candidates.sort()
    candidates.forEach { count[it] = (count[it] ?: 0) + 1 }
    fun dfs(i: Int, remain: Int) {
        if (remain == 0) {
            result.add(ArrayList(temp))
            return
        }
        if (i == candidates.size)
            return
        val j = i + (count[candidates[i]] ?: 1)
        dfs(j, remain)
        var left = remain
        repeat(minOf(j - i, remain / candidates[i])) {
            temp.add(candidates[i])
            left -= candidates[i]
            dfs(j, left)
        }
        temp.removeAll { it == candidates[i] }
    }
    dfs(0, target)
    return result
}
