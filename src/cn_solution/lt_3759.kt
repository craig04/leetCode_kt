package cn_solution

fun countElements(nums: IntArray, k: Int): Int {
    nums.sort()
    if (k == 0)
        return nums.size
    val pos = nums.size - k
    val max = nums[pos]
    for (i in pos - 1 downTo 0) {
        if (nums[i] < max)
            return i + 1
    }
    return 0
}