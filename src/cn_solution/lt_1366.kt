package cn_solution

fun rankTeams(votes: Array<String>): String {
    val n = votes[0].length
    val count = HashMap<Char, IntArray>()
    for (vote in votes)
        for (i in vote.indices)
            count.computeIfAbsent(vote[i]) { IntArray(n) }[i]++
    return count.entries.sortedWith { a, b ->
        val pos = (0 until n).indexOfFirst { a.value[it] != b.value[it] }
        if (pos != -1) b.value[pos] - a.value[pos] else a.key - b.key
    }.fold(StringBuilder()) { sb, e -> sb.append(e.key) }.toString()
}