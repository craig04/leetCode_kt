package cn_solution

fun rotateElements(nums: IntArray, k: Int): IntArray {
    val a = nums.filter { it >= 0 }
    var j = k
    for (i in nums.indices)
        if (nums[i] >= 0)
            nums[i] = a[j++ % a.size]
    return nums
}