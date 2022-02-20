package cn_solution

fun maxLengthBetweenEqualCharacters(s: String): Int {
    val start = IntArray(26)
    val end = IntArray(26)
    for (i in s.indices) {
        val idx = s[i] - 'a'
        if (start[idx] == 0) {
            start[idx] = i + 1
        }
        end[idx] = i + 1
    }
    return end.indices.fold(-1) { dis, i -> maxOf(dis, end[i] - start[i] - 1) }
}