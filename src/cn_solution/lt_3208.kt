package cn_solution

fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
    val n = colors.size
    var i = 0
    return (1 until n + k - 1).count { j ->
        if (colors[j % n] == colors[(j - 1) % n])
            i = j
        j - i + 1 >= k
    }
}