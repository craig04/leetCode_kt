package cn_solution

fun getMaximumGenerated(n: Int): Int {
    if (n == 0)
        return 0
    val a = IntArray(n + 1)
    a[1] = 1
    for (i in 2..n)
        if (i % 2 == 0)
            a[i] = a[i / 2]
        else
            a[i] = a[i / 2] + a[i / 2 + 1]
    return a.max()
}