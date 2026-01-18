package cn_solution

fun vowelConsonantScore(s: String): Int {
    var (v, c) = IntArray(2)
    for (i in s.indices)
        if (s[i].isLetter())
            if (s[i] in "aeiou")
                v++
            else
                c++
    return if (c == 0) 0 else v / c
}