package cn_solution

fun getHappyString(n: Int, k: Int): String {
    var s = 1.shl(n - 1)
    if (s * 3 < k)
        return ""
    val a = CharArray(n)
    var t = k - 1
    a[0] = 'a' + t / s
    t %= s
    for (i in 1 until n) {
        s /= 2
        a[i] = 'a' + t / s
        if (a[i] >= a[i - 1])
            a[i]++
        t %= s
    }
    return String(a)
}