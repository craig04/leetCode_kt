package cn_solution

fun minTime(skill: IntArray, mana: IntArray): Long {
    var start = 0L
    for (i in 1 until mana.size) {
        var delay = 0L
        var s = 0L
        var f = start
        for (j in skill.indices) {
            f += mana[i - 1] * skill[j]
            delay = maxOf(delay, f - s)
            s += mana[i] * skill[j]
        }
        start = delay
    }
    return start + mana.last() * 1L * skill.sum()
}