package cn_interview

fun waysToStep(n: Int): Int {
    fun multiply(a: Array<LongArray>, b: Array<LongArray>, c: Array<LongArray>) {
        for (i in c.indices)
            for (j in c[0].indices)
                c[i][j] = b.indices.fold(0L) { acc, k -> acc + a[i][k] * b[k][j] } % 1000000007
    }

    var base = arrayOf(
        longArrayOf(1, 1, 1),
        longArrayOf(1, 0, 0),
        longArrayOf(0, 1, 0)
    )
    var step = arrayOf(
        longArrayOf(1),
        longArrayOf(0),
        longArrayOf(0)
    )
    var nextBase = Array(3) { LongArray(3) }
    var nextStep = Array(3) { LongArray(1) }
    var m = n
    while (m != 0) {
        if (m and 1 == 1) {
            multiply(base, step, nextStep)
            val temp = step
            step = nextStep
            nextStep = temp
        }
        multiply(base, base, nextBase)
        val temp = base
        base = nextBase
        nextBase = temp
        m = m shr 1
    }
    return step[0][0].toInt()
}