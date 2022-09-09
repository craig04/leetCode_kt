package cn_solution

fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length)
        return false
    val n = s1.lastIndex
    val count = IntArray(26)
    s1.forEach { count[it - 'a']++ }
    (0 until n).forEach { count[s2[it] - 'a']-- }
    var diffs = count.count { it != 0 }
    for (i in n until s2.length) {
        when (count[s2[i] - 'a']--) {
            1 -> diffs--
            0 -> diffs++
        }
        if (diffs == 0)
            return true
        when (++count[s2[i - n] - 'a']) {
            0 -> diffs--
            1 -> diffs++
        }
    }
    return false
}