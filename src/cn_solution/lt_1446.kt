package cn_solution

fun maxPower(s: String): Int {
    var len = 1
    return (1 until s.length).maxOfOrNull { i ->
        if (s[i] != s[i - 1])
            len = 0
        ++len
    } ?: 1
}