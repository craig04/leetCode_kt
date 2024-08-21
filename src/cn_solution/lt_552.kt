package cn_solution

fun checkRecord(n: Int): Int {
    val modulo = 1000000007L
    val mat1 = arrayOf(
        longArrayOf(1, 1, 0, 1, 0, 0),
        longArrayOf(1, 0, 1, 1, 0, 0),
        longArrayOf(1, 0, 0, 1, 0, 0),
        longArrayOf(0, 0, 0, 1, 1, 0),
        longArrayOf(0, 0, 0, 1, 0, 1),
        longArrayOf(0, 0, 0, 1, 0, 0)
    )
    val mat2 = Array(6) { LongArray(6) }
    val cnt1 = longArrayOf(1, 0, 0, 0, 0, 0)
    val cnt2 = LongArray(6)
    var pow = n
    val range = 0 until 6
    while (pow != 0) {
        if (pow and 1 == 1) {
            for (j in range)
                cnt2[j] = cnt1.indices.sumOf { k -> cnt1[k] * mat1[k][j] } % modulo
            cnt2.copyInto(cnt1)
        }
        for (i in range)
            for (j in range)
                mat2[i][j] = range.sumOf { k -> mat1[i][k] * mat1[k][j] } % modulo
        for (k in range)
            mat2[k].copyInto(mat1[k])
        pow = pow shr 1
    }
    return (cnt1.sum() % modulo).toInt()
}