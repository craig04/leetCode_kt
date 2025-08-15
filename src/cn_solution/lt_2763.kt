package cn_solution

fun sumImbalanceNumbers(nums: IntArray): Int {
    val n = nums.size
    val pre = IntArray(n + 1)
    val suf = IntArray(n + 1)
    val pos = IntArray(n + 2) { -1 }
    for (i in nums.indices) {
        val num = nums[i]
        pre[i] = pos[num + 1]
        pos[num] = i
    }
    pos.fill(n)
    for (i in nums.indices.reversed()) {
        val num = nums[i]
        suf[i] = minOf(pos[num], pos[num + 1])
        pos[num] = i
    }
    return nums.indices.sumOf { (it - pre[it]) * (suf[it] - it) } - n * (n + 1) / 2
}