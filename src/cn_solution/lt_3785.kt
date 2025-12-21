package cn_solution

fun minSwaps(nums: IntArray, forbidden: IntArray): Int {
    val n = nums.size
    val cnt = HashMap<Int, Int>()
    val conflict = HashMap<Int, Int>()
    for (num in nums)
        cnt.merge(num, 1, Int::plus)
    var all = 0
    var max = 0
    for (i in 0 until n) {
        val num = forbidden[i]
        val cnt = cnt.merge(num, 1, Int::plus) ?: 1
        if (cnt > n)
            return -1
        if (num == nums[i]) {
            all++
            max = maxOf(max, conflict.merge(num, 1, Int::plus) ?: 1)
        }
    }
    return maxOf(max, (all + 1) / 2)
}