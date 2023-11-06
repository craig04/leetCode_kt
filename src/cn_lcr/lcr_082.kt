package cn_lcr

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val temp = ArrayList<Int>()
    candidates.sort()
    fun dfs(pos: Int, sum: Int) {
        if (sum == target) {
            result.add(ArrayList(temp))
            return
        }
        if (pos == candidates.size)
            return
        for (i in pos until candidates.size) {
            val next = sum + candidates[i]
            if (next > target)
                break
            if (i == pos || candidates[i] != candidates[i - 1]) {
                temp.add(candidates[i])
                dfs(i + 1, next)
                temp.removeLast()
            }
        }
    }
    dfs(0, 0)
    return result
}