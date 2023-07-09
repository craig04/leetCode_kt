package cn_solution

fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    val sp = Array(spells.size) { Pair(spells[it].toLong(), it) }
    sp.sortBy { it.first }
    potions.sort()
    var p = potions.lastIndex
    val result = IntArray(spells.size)
    for (i in sp.indices) {
        while (p >= 0 && sp[i].first * potions[p] >= success)
            p--
        result[sp[i].second] = potions.lastIndex - p
    }
    return result
}