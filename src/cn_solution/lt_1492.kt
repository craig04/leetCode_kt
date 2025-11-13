package cn_solution

fun kthFactor(n: Int, k: Int): Int {
    var num = 0
    var f = 1
    while (f * f < n) {
        if (n % f == 0 && ++num == k)
            return f
        f++
    }
    if (f * f == n && ++num == k)
        return f
    while (--f > 0)
        if (n % f == 0 && ++num == k)
            return n / f
    return -1
}