package cn_solution

fun countKDifference(nums: IntArray, k: Int): Int {
    val map = HashMap<Int, Int>()
    return nums.sumOf {
        map[it] = (map[it] ?: 0) + 1
        (map[it + k] ?: 0) + (map[it - k] ?: 0)
    }
}