package cn_solution

private fun countSubarrays(nums: IntArray, k: Long): Long {
    val min = ArrayDeque<Int>()
    val max = ArrayDeque<Int>()
    var i = 0
    return nums.indices.sumOf { j ->
        val num = nums[j]
        while (min.isNotEmpty() && num <= nums[min.last()])
            min.removeLast()
        min.add(j)
        while (max.isNotEmpty() && num >= nums[max.last()])
            max.removeLast()
        max.add(j)
        while ((j - i + 1L) * (nums[max.first()] - nums[min.first()]) > k) {
            if (i == min.first())
                min.removeFirst()
            if (i == max.first())
                max.removeFirst()
            i++
        }
        j - i + 1L
    }
}