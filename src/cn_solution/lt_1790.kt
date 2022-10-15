package cn_solution

fun areAlmostEqual(s1: String, s2: String): Boolean {
    var a = -1
    var b = -1
    for (i in s1.indices) {
        if (s1[i] == s2[i])
            continue
        when {
            a == -1 -> a = i
            b == -1 -> b = i
            else -> return false
        }
    }
    return a == -1 || b != -1 && s1[a] == s2[b] && s1[b] == s2[a]
}
