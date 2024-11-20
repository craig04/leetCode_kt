package cn_solution

fun validSequence(word1: String, word2: String): IntArray {
    val s = word1.toCharArray()
    val t = word2.toCharArray()
    val n = s.size
    val m = t.size
    val suf = IntArray(n + 1)
    suf[n] = m
    var j = m - 1
    for (i in n - 1 downTo 0) {
        if (j >= 0 && s[i] == t[j])
            j--
        suf[i] = j + 1
    }
    val ans = IntArray(m)
    var chance = true
    j = 0
    for (i in 0 until n) {
        if (s[i] == t[j] || (chance && suf[i + 1] <= j + 1)) {
            chance = chance && s[i] == t[j]
            ans[j++] = i
            if (j == m)
                break
        }
    }
    return if (j == m) ans else IntArray(0)
}