package cn_solution

fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
    if (m * n != original.size)
        return emptyArray()
    var idx = 0
    return Array(m) { IntArray(n) { original[idx++] } }
}