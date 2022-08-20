package cn_solution

fun preimageSizeFZF(k: Int): Int {

    fun trailingZeros(n: Long): Int {
        var result = 0
        var temp = n
        while (temp >= 5) {
            result += (temp / 5).toInt()
            temp /= 5
        }
        return result
    }

    var l = 0L
    var r = 4000000020L
    while (l < r) {
        val m = (l + r) shr 1
        val zeros = trailingZeros(m)
        when {
            zeros < k -> l = m + 1
            zeros > k -> r = m - 1
            else -> return 5
        }
    }
    return 0
}