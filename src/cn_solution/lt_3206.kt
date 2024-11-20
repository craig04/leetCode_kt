package cn_solution

fun numberOfAlternatingGroups(colors: IntArray): Int {
    val n = colors.size
    return colors.indices.count { j ->
        val i = (j + n - 1) % n
        val k = (j + 1) % n
        colors[i] != colors[j] && colors[j] != colors[k]
    }
}