package cn_solution

fun toggleLightBulbs(bulbs: List<Int>): List<Int> {
    val on = BooleanArray(101)
    for (b in bulbs)
        on[b] = !on[b]
    return on.indices.filter { on[it] }
}