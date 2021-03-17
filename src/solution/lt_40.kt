package solution

import java.util.*

/**
 * Dynamic Programming
 */
fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val dp = Array<HashSet<ArrayList<Int>>>(target + 1) { HashSet() }
    dp[0].add(arrayListOf())
    Arrays.sort(candidates)
    for (c in candidates) {
        for (i in target downTo c) {
            for (list in dp[i - c]) {
                dp[i].add(ArrayList(list).apply { add(c) })
            }
        }
    }
    return dp[target].toList()
}