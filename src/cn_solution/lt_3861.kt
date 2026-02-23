package cn_solution

fun minimumIndex(capacity: IntArray, itemSize: Int): Int {
    var min = Int.MAX_VALUE
    var pos = -1
    for (i in capacity.indices)
        if (capacity[i] in itemSize until min) {
            min = capacity[i]
            pos = i
        }
    return pos
}