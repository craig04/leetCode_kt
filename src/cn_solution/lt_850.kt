package cn_solution

import java.util.*

fun rectangleArea(rectangles: Array<IntArray>): Int {
    val w = TreeSet<Int>()
    val h = TreeSet<Int>()
    rectangles.forEach {
        w.add(it[0])
        h.add(it[1])
        w.add(it[2])
        h.add(it[3])
    }
    val wi = HashMap<Int, Int>()
    val wv = HashMap<Int, Int>()
    val hi = HashMap<Int, Int>()
    val hv = HashMap<Int, Int>()
    w.forEachIndexed { i, v ->
        wi[v] = i
        wv[i] = v
    }
    h.forEachIndexed { i, v ->
        hi[v] = i
        hv[i] = v
    }
    val grid = Array(w.size) { BooleanArray(h.size) }
    rectangles.forEach {
        for (i in wi[it[0]]!! until wi[it[2]]!!)
            for (j in hi[it[1]]!! until hi[it[3]]!!)
                grid[i][j] = true
    }
    var result = 0L
    for (i in 0 until grid.lastIndex)
        for (j in 0 until grid[i].lastIndex)
            if (grid[i][j]) {
                result += (wv[i + 1]!! - wv[i]!!).toLong() *
                        (hv[j + 1]!! - hv[j]!!)
            }
    return (result % 1000000007).toInt()
}
