package cn_solution

fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {
    val indices = Array(positions.size) { it }
    indices.sortBy { positions[it] }
    val s = ArrayList<Int>()
    for (i in indices) {
        if (directions[i] == 'R') {
            s.add(i)
            continue
        }
        while (healths[i] != 0 && s.isNotEmpty() && directions[s.last()] == 'R') {
            val j = s.last()
            val cmp = healths[j].compareTo(healths[i])
            if (cmp != 1 || --healths[j] == 0) {
                healths[j] = 0
                s.removeLast()
            }
            if (cmp != -1)
                healths[i] = 0
            else
                healths[i]--
        }
        if (healths[i] != 0)
            s.add(i)
    }
    return healths.filter { it != 0 }
}