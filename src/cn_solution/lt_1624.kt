package cn_solution

fun maxLengthBetweenEqualCharacters(s: String): Int {
    val first = IntArray(26) { -1 }
    var result = 0
    for (i in s.indices) {
        val t = s[i] - 'a'
        if (first[t] == -1) {
            first[t] = i
        } else {
            result = maxOf(result, i - first[t])
        }
    }
    return result - 1
}
