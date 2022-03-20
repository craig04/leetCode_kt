package cn_solution

fun countHighestScoreNodes(parents: IntArray): Int {
    val n = parents.size
    val count = IntArray(n + 1) { 1 }
    val left = IntArray(n) { n }
    val right = IntArray(n) { n }
    for (i in 1 until n) {
        val p = parents[i]
        if (left[p] == n) left[p] = i else right[p] = i
    }
    var result = 0
    var score = 0L
    fun dfs(i: Int): Int {
        if (i == n) return 0
        val l = dfs(left[i])
        val r = dfs(right[i])
        count[i] = l + r + 1
        val temp = 1L * count[left[i]] * count[right[i]] * if (i == 0) 1 else (n - count[i])
        if (temp > score) {
            score = temp
            result = 1
        } else if (temp == score) {
            result++
        }
        return count[i]
    }
    dfs(0)
    return result
}