package cn_lcr

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val adj = Array(numCourses) { ArrayList<Int>() }
    val degree = IntArray(numCourses)
    prerequisites.forEach { (a, b) ->
        adj[b].add(a)
        degree[a]++
    }
    val q = degree.indices.filterTo(ArrayList()) { degree[it] == 0 }
    val course = ArrayList<Int>()
    while (q.isNotEmpty()) {
        val c = q.removeLast()
        adj[c].forEach {
            if (--degree[it] == 0)
                q.add(it)
        }
        course.add(c)
    }
    return if (course.size == numCourses) course.toIntArray() else IntArray(0)
}