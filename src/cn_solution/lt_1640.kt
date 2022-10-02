package cn_solution

fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
    val first = pieces.groupBy { it[0] }
    var i = 0
    while (i != arr.size) {
        val p = first[arr[i]]?.get(0) ?: return false
        if (p.indices.any { p[it] != arr[i + it] })
            return false
        i += p.size
    }
    return true
}
