package cn_solution

fun arrayRankTransform(arr: IntArray): IntArray {
    var idx = 1
    val map = arr.toSortedSet().associateWith { idx++ }
    return IntArray(arr.size) { map[arr[it]] ?: 0 }
}