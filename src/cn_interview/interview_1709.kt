package cn_interview

fun getKthMagicNumber(k: Int): Int {
    val a = IntArray(k)
    a[0] = 1
    var p = 1
    var x = 0
    var y = 0
    var z = 0
    while (p < k) {
        val next = minOf(a[x] * 3, a[y] * 5, a[z] * 7)
        a[p++] = next
        if (a[x] * 3 == next)
            x++
        if (a[y] * 5 == next)
            y++
        if (a[z] * 7 == next)
            z++
    }
    return a[k - 1]
}