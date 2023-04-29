package cn_solution

fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
    val subordinate = Array(n) { ArrayList<Int>() }
    manager.forEachIndexed { i, boss ->
        if (boss != -1) subordinate[boss].add(i)
    }
    fun inform(id: Int): Int = informTime[id] +
            subordinate[id].fold(0) { time, i -> maxOf(time, inform(i)) }
    return inform(headID)
}