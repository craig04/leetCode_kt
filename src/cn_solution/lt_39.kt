package cn_solution

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val temp = ArrayList<Int>()
    fun dfs(i: Int, diff: Int) {
        if (i == candidates.size) {
            if (diff == 0)
                result.add(ArrayList(temp))
            return
        }
        dfs(i + 1, diff)
        var remain = diff
        for (t in 1..diff / candidates[i]) {
            temp.add(candidates[i])
            remain -= candidates[i]
            dfs(i + 1, remain)
        }
        temp.removeAll { it == candidates[i] }
    }
    dfs(0, target)
    return result
}
