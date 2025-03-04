package cn_solution

fun numOfPairs(nums: Array<String>, target: String): Int {
    val map = nums.groupingBy { it }.eachCount()
    return target.indices.sumOf { i ->
        val x = target.substring(0, i)
        val y = target.substring(i)
        val a = map[x] ?: 0
        var b = map[y] ?: 0
        if (a != 0 && i == target.length / 2 && x == y)
            b--
        a * b
    }
}