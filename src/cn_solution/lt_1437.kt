package cn_solution

fun kLengthApart(nums: IntArray, k: Int): Boolean {
    var prev = Int.MIN_VALUE / 2
    return nums.indices.all { curr ->
        if (nums[curr] == 0)
            return@all true
        val dist = curr - prev
        prev = curr
        dist > k
    }
}