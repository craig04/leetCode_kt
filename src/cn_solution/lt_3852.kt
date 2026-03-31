package cn_solution

fun minDistinctFreqPair(nums: IntArray): IntArray {
    val map = HashMap<Int, Int>()
    var x = Int.MAX_VALUE
    for (num in nums) {
        map.merge(num, 1, Int::plus)
        x = minOf(x, num)
    }
    val cnt = map[x] ?: 0
    var y = Int.MAX_VALUE
    for ((k, v) in map)
        if (v != cnt)
            y = minOf(y, k)
    if (y == Int.MAX_VALUE) {
        x = -1
        y = -1
    }
    return intArrayOf(x, y)
}