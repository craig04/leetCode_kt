package cn_interview

fun smallestDifference(a: IntArray, b: IntArray): Int {
    var result = Long.MAX_VALUE
    a.sort()
    b.sort()
    var i = 0
    for (n in b) {
        while (i != a.size && a[i] < n)
            i++
        if (i != 0)
            result = minOf(result, n.toLong() - a[i - 1])
        if (i != a.size) {
            result = minOf(result, a[i] - n.toLong())
        }
    }
    return result.toInt()
}