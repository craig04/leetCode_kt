package cn_solution

fun minRemovals(nums: IntArray, target: Int): Int {
    val len = 32 - nums.max().countLeadingZeroBits()
    val max = 1 shl len
    if (target >= max)
        return -1
    val cnt = IntArray(max) { Int.MIN_VALUE }
    val tmp = IntArray(max) { Int.MIN_VALUE }
    cnt[0] = 0
    for (num in nums) {
        cnt.copyInto(tmp)
        for (i in 0 until max)
            cnt[i] = maxOf(cnt[i], tmp[i xor num] + 1)
    }
    return if (cnt[target] < 0) -1 else nums.size - cnt[target]
}