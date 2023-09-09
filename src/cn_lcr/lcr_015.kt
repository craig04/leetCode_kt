package cn_lcr

fun findAnagrams(s: String, p: String): List<Int> {
    if (s.length < p.length)
        return emptyList()
    val diff = IntArray(26)
    p.indices.forEach {
        diff[p[it] - 'a']++
        diff[s[it] - 'a']--
    }
    var count = diff.count { it != 0 }
    val result = ArrayList<Int>()
    if (count == 0)
        result.add(0)
    for (i in p.length until s.length) {
        when (--diff[s[i] - 'a']) {
            0 -> count--
            -1 -> count++
        }
        when (++diff[s[i - p.length] - 'a']) {
            0 -> count--
            1 -> count++
        }
        if (count == 0)
            result.add(i - p.lastIndex)
    }
    return result
}