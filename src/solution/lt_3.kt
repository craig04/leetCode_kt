package solution

fun lengthOfLongestSubstring(s: String): Int {
    val end = Array(128) { -1 }
    var begin = -1
    var result = 0
    s.toCharArray().forEachIndexed { idx, c ->
        val ci = c.code
        begin = maxOf(begin, end[ci])
        end[ci] = idx
        result = maxOf(result, idx - begin)
    }
    return result
}