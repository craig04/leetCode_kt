package cn_solution

fun arrayRankTransform(arr: IntArray): IntArray {
    val map = arr.toSortedSet().toIntArray().run { indices.associateBy { this[it] } }
    return IntArray(arr.size) { map[arr[it]]!! + 1 }
}