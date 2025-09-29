package cn_solution

private fun zigZagArrays(n: Int, l: Int, r: Int): Int {
    val mod = 1000000007
    val k = r - l + 1
    val rise = IntArray(k + 1) { it }
    val fall = IntArray(k + 1) { it }
    val a = IntArray(k + 1)
    val b = IntArray(k + 1)
    for (i in 1 until n) {
        for (j in 1..k) {
            a[j] = fall[j - 1]
            b[j] = (rise[k] - rise[j] + mod) % mod
        }
        for (j in 1..k) {
            rise[j] = (rise[j - 1] + a[j]) % mod
            fall[j] = (fall[j - 1] + b[j]) % mod
        }
    }
    return (rise[k] + fall[k]) % mod
}