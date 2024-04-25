package cn_solution

fun minimumRefill(plants: IntArray, capacityA: Int, capacityB: Int): Int {
    var count = 0
    var a = capacityA
    var b = capacityB
    var p = 0
    var q = plants.lastIndex
    while (p < q) {
        if (a < plants[p]) {
            a = capacityA - plants[p++]
            count++
        } else {
            a -= plants[p++]
        }
        if (b < plants[q]) {
            b = capacityB - plants[q--]
            count++
        } else {
            b -= plants[q--]
        }
    }
    if (p == q && maxOf(a, b) < plants[p])
        count++
    return count
}