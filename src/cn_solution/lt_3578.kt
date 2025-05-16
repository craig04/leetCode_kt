package cn_solution

import java.util.*

fun countPartitions(nums: IntArray, k: Int): Int {
    val mod = 1000000007
    val n = nums.size
    val suf = IntArray(n + 2)
    suf[n] = 1
    var j = n - 1
    val map = TreeMap<Int, Int>()
    for (i in n - 1 downTo 0) {
        map.merge(nums[i], 1, Int::plus)
        while (map.lastKey() - map.firstKey() > k)
            map.merge(nums[j--], -1) { a, b ->
                if (a + b == 0) null else a + b
            }
        suf[i] = suf[i + 1] * 2 - suf[j + 2]
        when {
            suf[i] < 0 -> suf[i] += mod
            suf[i] >= mod -> suf[i] -= mod
        }
    }
    return (suf[0] + mod - suf[1]) % mod
}