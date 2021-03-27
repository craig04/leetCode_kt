package solution_cn

private fun lengthOfLongestSubstring(s: String): Int {
    var result = 0
    var start = 0
    val end = Array(128) { -1 }
    s.toCharArray().forEachIndexed { i, c ->
        val ci = c.toInt()
        start = maxOf(start, end[ci])
        end[ci] = i
        result = maxOf(result, i - start)
    }
    return result
}