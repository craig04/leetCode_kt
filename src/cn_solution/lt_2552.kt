package cn_solution

fun countQuadruplets(nums: IntArray): Long {
    val n = nums.size
    val pre = IntArray(n + 1)
    var ans = 0L
    for (j in nums.indices) {
        var suf = 0
        for (k in n - 1 downTo j + 1) {
            if (nums[j] > nums[k])
                ans += pre[nums[k]] * suf
            else
                suf++
        }
        for (t in nums[j] + 1..n)
            pre[t]++
    }
    return ans
}