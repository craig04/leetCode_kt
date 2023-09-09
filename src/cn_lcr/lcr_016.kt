package cn_lcr

fun lengthOfLongestSubstring(s: String): Int {
    val map = IntArray(128) { -1 }
    var begin = -1
    var result = 0
    for (i in s.indices) {
        val idx = s[i].toInt()
        begin = begin.coerceAtLeast(map[idx])
        result = result.coerceAtLeast(i - begin)
        map[idx] = i
    }
    return result
}