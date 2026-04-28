package cn_solution

fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
    var x = 0L
    var y = 0L
    return IntArray(A.size) {
        x = 1L.shl(A[it]).or(x)
        y = 1L.shl(B[it]).or(y)
        x.and(y).countOneBits()
    }
}