package cn_solution

fun distinctNames(ideas: Array<String>): Long {
    val suf = Array(26) { HashSet<String>() }
    for (idea in ideas)
        suf[idea[0] - 'a'].add(idea.substring(1))
    var ans = 0L
    for (i in 0 until 26) {
        for (j in 0 until i) {
            val dup = suf[j].count { it in suf[i] }
            ans += (suf[i].size - dup) * 1L * (suf[j].size - dup)
        }
    }
    return ans * 2
}