package cn_solution

fun mostCompetitive(nums: IntArray, k: Int): IntArray {
    val res = IntArray(k)
    var top = 0
    val n = nums.size
    for (i in nums.indices) {
        val num = nums[i]
        while (top > maxOf(0, i + k - n) && num < res[top - 1])
            top--
        if (top != k)
            res[top++] = num
    }
    return res
}