package cn_solution

fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val count = HashMap<Int, Int>()
    for ((winner, loser) in matches) {
        count.putIfAbsent(winner, 0)
        count[loser] = (count[loser] ?: 0) + 1
    }
    val result = Array(2) { ArrayList<Int>() }
    for ((k, v) in count)
        if (v <= 1) result[v].add(k)
    result[0].sort()
    result[1].sort()
    return result.asList()
}