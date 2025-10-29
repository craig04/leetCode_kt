package cn_solution

fun countCoprime(mat: Array<IntArray>): Int {
    fun gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
    val max = mat.maxOf { it.max() }
    val pre = IntArray(max + 1)
    val cur = IntArray(max + 1)
    pre[0] = 1
    for (row in mat) {
        for (num in row)
            for (old in 0..max)
                if (pre[old] != 0) {
                    val new = gcd(old, num)
                    cur[new] = (cur[new] + pre[old]) % 1000000007
                }
        for (i in 0..max) {
            pre[i] = cur[i]
            cur[i] = 0
        }
    }
    return pre[1]
}