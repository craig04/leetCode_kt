package cn_solution

fun truncateSentence(s: String, k: Int): String {
    var cnt = 0
    for (i in s.indices)
        if (s[i] == ' ' && ++cnt == k)
            return s.take(i)
    return s
}