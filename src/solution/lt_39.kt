package solution

/**
 * Dynamic programming
 */
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val dp = Array(target + 1) { ArrayList<IntArray>() }
    dp[0].add(IntArray(candidates.size))
    candidates.forEachIndexed { idx, c ->
        for (i in c..target) {
            for (array in dp[i - c]) {
                val temp = IntArray(candidates.size) { array[it] }
                temp[idx]++
                dp[i].add(temp)
            }
        }
    }
    return dp[target].map {
        val list = ArrayList<Int>()
        it.forEachIndexed { idx, times -> repeat(times) { list.add(candidates[idx]) } }
        list
    }
}

/**
 * Recursion & brute force
 */
fun combinationSum_2(candidates: IntArray, target: Int): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    combinationSum_2(candidates, target, 0, mutableListOf(), result)
    return result
}

private fun combinationSum_2(candidates: IntArray,
                             target: Int,
                             index: Int,
                             temp: MutableList<Int>,
                             result: MutableList<List<Int>>) {
    if (target == 0) {
        result.add(ArrayList(temp))
    } else if (index != candidates.size) {
        val num = candidates[index]
        var remain = target
        while (remain >= 0) {
            combinationSum_2(candidates, remain, index + 1, temp, result)
            temp.add(num)
            remain -= num
        }
        temp.removeAll { it == num }
    }
}