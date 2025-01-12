package cn_solution

import java.util.BitSet

fun maxValue(nums: IntArray, k: Int): Int {
    val n = nums.size
    val m = 128
    val r = Array(n + 1) { Array(k + 1) { BitSet(m) } }
    r[n][0][0] = true
    for (i in n - 1 downTo k) {
        for (j in k downTo 0)
            for (x in 0 until m)
                if (r[i + 1][j][x]) {
                    r[i][j][x] = true
                    if (j != k)
                        r[i][j + 1][x or nums[i]] = true
                }
    }
    var ans = 0
    val l = Array(k + 1) { BitSet(m) }
    l[0][0] = true
    for (i in 0 until n - k) {
        for (j in k downTo 1)
            for (x in 0 until m)
                if (l[j - 1][x])
                    l[j][x or nums[i]] = true
        for (x in 0 until m)
            if (l[k][x])
                for (y in 0 until m)
                    if (r[i + 1][k][y])
                        ans = maxOf(ans, x xor y)
    }
    return ans
}