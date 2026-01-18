package cn_solution

fun mergeAdjacent(nums: IntArray): List<Long> {
    val s = ArrayList<Long>()
    for (i in nums.indices) {
        var num = nums[i] + 0L
        while (s.isNotEmpty() && num == s.last())
            num += s.removeLast()
        s.add(num)
    }
    return s
}