package cn_solution

fun longestSubarray(nums: IntArray, limit: Int): Int {
    val min = ArrayDeque<Int>()
    val max = ArrayDeque<Int>()
    var i = 0
    return nums.indices.maxOf { j ->
        val x = nums[j]
        while (min.isNotEmpty() && x <= nums[min.last()])
            min.removeLast()
        while (max.isNotEmpty() && x >= nums[max.last()])
            max.removeLast()
        min += j
        max += j
        while (nums[max.first()] - nums[min.first()] > limit) {
            if (min.first() == i)
                min.removeFirst()
            if (max.first() == i)
                max.removeFirst()
            i++
        }
        j - i + 1
    }
}