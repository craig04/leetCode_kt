package cn_solution

fun maximumGap(skill: String, station: String): Int {
    val n = skill.length
    val suf = IntArray(n + 1)
    var i = n - 1
    for (j in station.indices.reversed())
        if (skill[i] == station[j]) {
            suf[i--] = j
            if (i == -1)
                break
        }
    i = 0
    var ans = 0
    for (j in station.indices)
        if (skill[i] == station[j]) {
            ans = maxOf(ans, suf[i + 1] - j)
            if (++i == n)
                break
        }
    return ans
}