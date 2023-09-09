package cn_lcr

fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length)
        return false
    val count = IntArray(26)
    s1.indices.forEach {
        count[s1[it] - 'a']++
        count[s2[it] - 'a']--
    }
    var diffs = count.count { it != 0 }
    return diffs == 0 || (s1.length until s2.length).any {
        when (count[s2[it] - 'a']--) {
            1 -> diffs--
            0 -> diffs++
        }
        when (++count[s2[it - s1.length] - 'a']) {
            0 -> diffs--
            1 -> diffs++
        }
        diffs == 0
    }
}