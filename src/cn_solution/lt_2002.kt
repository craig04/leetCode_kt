package cn_solution

fun maxProduct(s: String): Int {
    var ans = 1
    val n = s.length
    val m = 1.shl(n) - 1
    fun test(x: Int): Boolean {
        var i = 0
        var j = n - 1
        while (true) {
            while (i < j && 1.shl(i).and(x) == 0)
                i++
            while (i < j && 1.shl(j).and(x) == 0)
                j--
            when {
                i >= j -> return true
                s[i++] != s[j--] -> return false
            }
        }
    }
    for (i in 1 until m) {
        val k = i xor m
        var j = k
        while (j != 0) {
            if (test(i) && test(j))
                ans = maxOf(ans, i.countOneBits() * j.countOneBits())
            j = (j - 1).and(k)
        }
    }
    return ans
}