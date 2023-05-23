package cn_interview

fun merge(A: IntArray, m: Int, B: IntArray, n: Int): Unit {
    var i = m - 1
    var j = n - 1
    var k = m + n
    while (i != -1 && j != -1)
        A[--k] = if (A[i] < B[j]) B[j--] else A[i--]
    if (j != -1)
        B.copyInto(A, 0, 0, j + 1)
}