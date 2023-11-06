package cn_solution

fun minSwapsCouples(row: IntArray): Int {
    val n = row.size
    val seat = IntArray(n)
    var result = 0
    row.forEachIndexed { i, p -> seat[p] = i }
    for (i in 0 until n step 2) {
        val a = row[i]
        val b = row[i + 1]
        val c = a xor 1
        if (b != c) {
            row[seat[c]] = b
            seat[b] = seat[c]
            row[i + 1] = c
            seat[c] = i + 1
            result++
        }
    }
    return result
}