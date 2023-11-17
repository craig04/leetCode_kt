package cn_solution

fun findContentChildren(g: IntArray, s: IntArray): Int {
    g.sort()
    s.sort()
    var i = 0
    var result = 0
    for (t in s) {
        if (t < g[i])
            continue
        result++
        if (++i == g.size)
            break
    }
    return result
}