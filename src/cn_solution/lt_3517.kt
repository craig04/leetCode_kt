package cn_solution

fun smallestPalindrome(s: String): String {
    val c = s.toCharArray()
    val cnt = IntArray(26)
    for (i in 0 until c.size / 2)
        cnt[c[i] - 'a']++
    var i = 0
    var j = c.lastIndex
    for (t in cnt.indices)
        repeat(cnt[t]) {
            c[i++] = 'a' + t
            c[j--] = 'a' + t
        }
    return String(c)
}