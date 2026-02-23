package cn_solution

fun trimTrailingVowels(s: String): String {
    for (i in s.indices.reversed())
        if (s[i] !in "aeiou")
            return s.take(i + 1)
    return ""
}