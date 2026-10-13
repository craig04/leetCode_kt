package cn_solution

fun canRemoveAll(types: IntArray, colors: IntArray, groupSize: IntArray): Boolean {
    val s = arrayListOf(intArrayOf(-1, -1, 0))
    for (i in types.indices) {
        val type = types[i]
        val color = colors[i]
        if (type != s.last()[0] || color != s.last()[1])
            s += intArrayOf(type, color, 0)
        if (++s.last()[2] == groupSize[type])
            s.removeLast()
    }
    return s.size == 1
}