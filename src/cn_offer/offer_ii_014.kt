package cn_offer

fun checkInclusion(s1: String, s2: String): Boolean {
    val count = IntArray(26)
    s1.forEach { count[it - 'a']++ }
    var nonZeros = count.count { it != 0 }
    s2.forEachIndexed { i, c ->
        when (--count[c - 'a']) {
            0 -> nonZeros--
            -1 -> nonZeros++
        }
        if (nonZeros == 0) {
            return true
        }
        if (i >= s1.length - 1) {
            when (++count[s2[i - s1.length + 1] - 'a']) {
                0 -> nonZeros--
                1 -> nonZeros++
            }
        }
    }
    return false
}