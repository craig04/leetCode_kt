package cn_solution

fun dividePlayers(skill: IntArray): Long {
    val map = HashMap<Int, Int>()
    var sum = 0L
    val n = skill.size
    for (s in skill) {
        map.merge(s, 1, Int::plus)
        sum += s
    }
    if (sum % (n / 2) != 0L)
        return -1
    val bin = (sum * 2 / n).toInt()
    var ans = 0L
    for ((k, v) in map) {
        val cnt = map[bin - k] ?: 0
        if (cnt != v)
            return -1L
        ans += 1L * k * (bin - k) * v
    }
    return ans / 2
}