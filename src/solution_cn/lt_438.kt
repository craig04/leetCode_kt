package solution_cn

fun findAnagrams(s: String, p: String): List<Int> {
    if (s.length < p.length) {
        return emptyList()
    }
    val count = IntArray(26)
    val sa = s.toCharArray()
    val pa = p.toCharArray()
    for (i in p.indices) {
        count[sa[i] - 'a']--
        count[pa[i] - 'a']++
    }
    val result = ArrayList<Int>()
    var diff = count.count { it != 0 }
    if (diff == 0) {
        result.add(0)
    }
    for (i in 0 until s.length - p.length) {
        when (--count[sa[i + p.length] - 'a']) {
            -1 -> diff++
            0 -> diff--
        }
        when (++count[sa[i] - 'a']) {
            1 -> diff++
            0 -> diff--
        }
        if (diff == 0) {
            result.add(i + 1)
        }
    }
    return result
}