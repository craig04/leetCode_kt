package cn_solution

fun minStable(nums: IntArray, maxC: Int): Int {
    fun gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
    val n = nums.size
    val m = 33 - (n - 1).countLeadingZeroBits()
    val gcd = Array(n) { IntArray(m) }
    for (i in nums.indices)
        gcd[i][0] = nums[i]
    for (len in 1 until m)
        for (i in nums.indices) {
            val half = 1.shl(len - 1)
            if (i + half < n)
                gcd[i][len] = gcd(gcd[i][len - 1], gcd[i + half][len - 1])
        }
    fun getGCD(i: Int, len: Int): Int {
        var res = 0
        var j = i
        var t = len
        while (t != 0) {
            val zero = t.countTrailingZeroBits()
            res = gcd(gcd[j][zero], res)
            j += 1.shl(zero)
            t = t and (t - 1)
        }
        return res
    }

    var l = 0
    var r = n
    while (l < r) {
        val mid = (l + r) shr 1
        fun check(): Boolean {
            var cnt = 0
            var i = 0
            while (i + mid < n) {
                if (getGCD(i, mid + 1) == 1)
                    i++
                else {
                    if (++cnt > maxC)
                        return false
                    i += mid + 1
                }
            }
            return true
        }
        if (check())
            r = mid
        else
            l = mid + 1
    }
    return l
}