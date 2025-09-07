package cn_solution

fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
    val n = nums.size
    var pre = 0
    var suf = nums.sum()
    return IntArray(n) { i ->
        val num = nums[i]
        pre += num
        suf -= num
        suf - pre + (2 * i + 2 - n) * num
    }
}