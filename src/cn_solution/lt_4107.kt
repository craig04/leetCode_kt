package cn_solution

private fun countSuffix(nums: IntArray, target: IntArray): Int {
    val n = nums.size
    val cnt = IntArray(100001)
    for (i in 0 until n) {
        cnt[nums[i]]++
        cnt[target[i]]--
    }
    if (cnt.any { it != 0 })
        return 0
    var r = 0
    while (r != n - 1 && nums[r] == target[r])
        r++
    var l = n - 1
    while (l != 0 && target[l - 1] >= target[l])
        l--
    return maxOf(0, r - l + 1)
}