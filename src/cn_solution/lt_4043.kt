package cn_solution

fun countRotations(s: String, k: Int): Int {
    var pre = s.last()
    var cnt = 0
    for (i in s.indices) {
        if (s[i] != pre)
            cnt++
        pre = s[i]
    }
    return when (cnt) {
        k -> s.length - k
        k + 1 -> k + 1
        else -> 0
    }
}