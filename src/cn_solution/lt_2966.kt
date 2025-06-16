package cn_solution

fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
    val n = nums.size
    val ans = Array(n / 3) { IntArray(3) }
    nums.sort()
    for (i in 0 until n step 3) {
        if (nums[i + 2] - nums[i] > k)
            return emptyArray()
        nums.copyInto(ans[i / 3], 0, i, i + 3)
    }
    return ans
}