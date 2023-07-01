package cn_solution

fun longestOnes(nums: IntArray, k: Int): Int {
    var l = 0
    var zero = 0
    return nums.indices.fold(0) { res, r ->
        if (nums[r] == 0)
            zero++
        while (zero > k)
            if (nums[l++] == 0)
                zero--
        maxOf(res, r - l + 1)
    }
}