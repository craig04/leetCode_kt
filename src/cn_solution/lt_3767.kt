package cn_solution

fun maxPoints(technique1: IntArray, technique2: IntArray, k: Int): Long {
    val tech = Array(technique1.size) { intArrayOf(technique1[it], technique2[it]) }
    tech.sortBy { it[1] - it[0] }
    var ans = 0L
    for (i in tech.indices)
        ans += if (i < k || tech[i][0] > tech[i][1]) tech[i][0] else tech[i][1]
    return ans
}