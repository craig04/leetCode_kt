package cn_solution

fun moveZeroes(nums: IntArray): Unit {
    var i = 0
    for (n in nums)
        if (n != 0)
            nums[i++] = n
    nums.fill(0, i)
}