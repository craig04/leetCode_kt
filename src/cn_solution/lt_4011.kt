package cn_solution

private fun countRatioSubarrays(nums: IntArray, a: Int, b: Int): Int {
    return nums.indices.sumOf { i ->
        var even = 0
        var odd = 0
        (i until nums.size).count { j ->
            if (nums[j] % 2 == 0)
                even++
            else
                odd++
            even * b <= odd * a
        }
    }
}