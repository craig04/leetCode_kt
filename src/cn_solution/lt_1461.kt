package cn_solution

fun hasAllCodes(s: String, k: Int): Boolean {
    val high = 1 shl k
    val mask = high - 1
    val has = BooleanArray(high)
    var cnt = 0
    var x = 0
    for (i in s.indices) {
        x = x shl 1 and mask or (s[i] - '0')
        if (i >= k - 1 && !has[x]) {
            has[x] = true
            if (++cnt == high)
                return true
        }
    }
    return false
}