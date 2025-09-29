package cn_solution

fun findSmallestInteger(nums: IntArray, value: Int): Int {
    val cnt = IntArray(value)
    for (num in nums)
        cnt[Math.floorMod(num, value)]++
    val idx = cnt.indices.minBy { cnt[it] }
    return idx + value * cnt[idx]
}