package solution

fun getMaximumGenerated(n: Int): Int {
    if (n <= 1) {
        return n
    }
    val a = arrayListOf(0, 1)
    var result = 0
    for (i in 2..n) {
        val h = i shr 1
        val next = a[h] + if (i and 1 == 1) a[h + 1] else 0
        result = maxOf(next, result)
        a.add(next)
    }
    return result
}