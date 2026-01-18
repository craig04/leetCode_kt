package cn_solution

fun firstUniqueFreq(nums: IntArray): Int {
    val cnt = nums.asSequence().groupingBy { it }.eachCount()
    val map = HashMap<Int, Int>()
    for ((_, v) in cnt)
        map.merge(v, 1, Int::plus)
    return nums.firstOrNull { map[cnt[it]] == 1 } ?: -1
}