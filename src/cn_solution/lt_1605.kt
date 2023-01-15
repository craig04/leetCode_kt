package cn_solution

fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
    return Array(rowSum.size) { i ->
        IntArray(colSum.size) { j ->
            minOf(rowSum[i], colSum[j]).also {
                rowSum[i] -= it
                colSum[j] -= it
            }
        }
    }
}