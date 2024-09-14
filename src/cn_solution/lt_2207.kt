package cn_solution

fun maximumSubsequenceCount(text: String, pattern: String): Long {
    val (x, y) = pattern.toCharArray()
    var a = 0L
    var b = 0L
    var ans = 0L
    for (c in text) {
        if (c == y) {
            ans += a
            b++
        }
        if (c == x)
            a++
    }
    return ans + maxOf(a, b)
}