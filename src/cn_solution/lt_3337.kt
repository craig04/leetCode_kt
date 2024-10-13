package cn_solution

fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Int {
    val modulo = 1000000007
    fun multiply(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
        val l = a.size
        val m = b.size
        val n = b[0].size
        val res = Array(l) { IntArray(n) }
        for (i in 0 until l)
            for (k in 0 until n)
                for (j in 0 until m)
                    res[i][k] = (res[i][k] + 1L * a[i][j] * b[j][k] % modulo).toInt() % modulo
        return res
    }

    var pow = Array(26) { IntArray(26) }
    for (i in 0 until 26)
        for (j in 1..nums[i])
            pow[i][(i + j) % 26] = 1
    var mat = Array(26) { IntArray(26) }
    for (i in 0 until 26)
        mat[i][i] = 1
    var k = t
    while (k != 0) {
        if (k and 1 == 1)
            mat = multiply(mat, pow)
        pow = multiply(pow, pow)
        k = k shr 1
    }
    val cnt = Array(1) { IntArray(26) }
    s.forEach { cnt[0][it - 'a']++ }
    val ans = multiply(cnt, mat)
    return ans[0].fold(0) { acc, c -> (acc + c) % modulo }
}