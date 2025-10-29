package cn_solution

fun hasSameDigits(s: String): Boolean {
    val a = IntArray(s.length) { s[it] - '0' }
    for (len in a.size downTo 3)
        for (i in 1 until len)
            a[i - 1] = (a[i - 1] + a[i]) % 10
    return a[0] == a[1]
}