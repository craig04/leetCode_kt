package cn_solution

fun triangleNumber(nums: IntArray): Int {
    nums.sort()
    var result = 0
    val n = nums.size
    for (i in 0 until n - 2) {
        var j = i + 1
        for (k in i + 2 until n) {
            while (j < k && nums[i] + nums[j] <= nums[k])
                j++
            result += k - j
        }
    }
    return result
}