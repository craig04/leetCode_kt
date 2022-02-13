package cn_solution

fun maxWidthRamp(A: IntArray): Int {
    val des = arrayListOf(-1)
    val idx = arrayListOf<Int>()
    var res = 0
    A.forEachIndexed { i, a ->
        var l = 0
        var r = des.size - 1
        while (l != r) {
            val m = (l + r) shr 1
            when {
                des[m] <= a -> r = m
                else -> l = m + 1
            }
        }
        if (l == des.size - 1) {
            des[l] = a
            des.add(-1)
            idx.add(i)
        } else {
            res = maxOf(res, i - idx[l])
        }
    }
    return res
}

fun maxWidthRamp2(A: IntArray): Int {
    val idx = A.indices.sortedBy { A[it] }
    var min = A.size
    var res = 0
    idx.forEach {
        res = maxOf(res, it - min)
        min = minOf(min, it)
    }
    return res
}