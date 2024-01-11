package cn_solution

fun minimumSeconds(nums: List<Int>): Int {
    val map = HashMap<Int, IntArray>()
    val func = { _: Int -> intArrayOf(-1, 0, 0) }
    for (i in nums.indices) {
        val a = map.computeIfAbsent(nums[i], func)
        if (a[0] == -1)
            a[0] = i
        else
            a[2] = maxOf(i - a[1], a[2])
        a[1] = i
    }
    return map.values.minOf { maxOf(it[2], it[0] + nums.size - it[1]) / 2 }
}