package cn_offer

fun constructArr(a: IntArray): IntArray {
    val n = a.size
    if (n == 0)
        return IntArray(0)
    val pre = IntArray(n)
    val suf = IntArray(n)
    pre[0] = 1
    suf[n - 1] = 1
    for (i in 1 until n) {
        pre[i] = pre[i - 1] * a[i - 1]
        suf[n - 1 - i] = suf[n - i] * a[n - i]
    }
    return IntArray(n) { pre[it] * suf[it] }
}