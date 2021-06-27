package solution_cn

fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
    (1 until arr.size).forEach {
        arr[it] = arr[it] xor arr[it - 1]
    }
    return IntArray(queries.size) {
        val q = queries[it]
        arr[q[1]] xor if (q[0] == 0) 0 else arr[q[0] - 1]
    }
}