package cn_lcr

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length)
        return false
    val count = IntArray(26)
    var diff = false
    for (i in s.indices) {
        count[s[i] - 'a']++
        count[t[i] - 'a']--
        diff = diff || (s[i] != t[i])
    }
    return diff && count.all { it == 0 }
}