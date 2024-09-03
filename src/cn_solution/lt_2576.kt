package cn_solution

fun maxNumOfMarkedIndices(nums: IntArray): Int {
    nums.sort()
    val n = nums.size
    var j = (n + 1) shr 1
    var ans = 0
    for (i in 0 until n / 2) {
        while (j != n && nums[j] < nums[i] * 2)
            j++
        if (j++ == n)
            break
        ans += 2
    }
    return ans
}