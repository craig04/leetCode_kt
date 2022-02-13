package cn_solution

fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {

    class Helper(var n: Int = 0)

    val map = HashMap<String, Helper>()
    var result = 0
    for (a in matrix) {
        result = maxOf(result, ++map.getOrPut(buildString {
            for (i in a.indices.reversed()) {
                append(a[i] xor a[0])
            }
        }) { Helper() }.n)
    }
    return result
}