package cn_solution

private fun minOperations(nums: IntArray): Int {
    val n = nums.size
    var x = 0
    var y = 0
    var inc = 0
    var dec = 0
    for (i in 1 until n) {
        if (nums[i - 1] < nums[i]) {
            x = i
            inc++
        } else {
            y = i
            dec++
        }
    }
    return when {
        dec == 0 -> 0
        inc == 0 -> 1
        dec == 1 && nums[0] > nums[n - 1] -> minOf(y, n - y + 2)
        inc == 1 && nums[0] < nums[n - 1] -> minOf(x + 1, n - x + 1)
        else -> -1
    }
}