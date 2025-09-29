package cn_solution

fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    val a = Array(spells.size) { intArrayOf(spells[it], it) }
    a.sortBy { it[0] }
    potions.sortDescending()
    var j = 0
    val result = IntArray(spells.size)
    for ((spell, i) in a) {
        while (j < potions.size && 1L * spell * potions[j] >= success)
            j++
        result[i] = j
    }
    return result
}