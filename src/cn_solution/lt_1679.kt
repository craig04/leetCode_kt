package cn_solution

fun maxOperations(nums: IntArray, k: Int): Int {
    val map = HashMap<Int, Int>()
    return nums.count {
        val c = map[k - it] ?: 0
        if (c >= 1) {
            map[k - it] = c - 1
            true
        } else {
            map[it] = (map[it] ?: 0) + 1
            false
        }
    }
}