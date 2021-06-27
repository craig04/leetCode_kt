package solution_cn

fun maxLength(arr: List<String>): Int {
    val a = ArrayList<Int>()
    loop@ for (s in arr) {
        var bits = 0
        for (c in s) {
            val b = 1 shl (c - 'a')
            if (b and bits != 0) {
                continue@loop
            }
            bits = bits or b
        }
        a.add(bits)
    }
    val dp = IntArray(1 shl a.size) { 0 }
    dp[0] = 0
    a.forEachIndexed { index, i ->
        val bit = 1.shl(index)
        for (j in 0 until bit) {
            if (dp[j] and i == 0) {
                dp[j or bit] = dp[j] or i
            }
        }
    }
    return dp.fold(0) { acc, i -> maxOf(acc, Integer.bitCount(i)) }
}