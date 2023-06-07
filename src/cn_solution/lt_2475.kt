package cn_solution

fun unequalTriplets(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    nums.forEach { map[it] = (map[it] ?: 0) + 1 }
    var count = 0
    return map.entries.fold(0) { res, (_, v) ->
        val next = res + count * v * (nums.size - count - v)
        count += v
        next
    }
}