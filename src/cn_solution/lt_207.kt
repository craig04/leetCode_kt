package cn_solution

import java.util.ArrayDeque
import java.util.ArrayList

/**
 * BFS (Topological sort)
 */
fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val q = ArrayDeque<Int>()
    val prev = IntArray(numCourses)
    val next = Array(numCourses) { ArrayList<Int>() }
    var count = 0
    prerequisites.forEach { (a, b) ->
        prev[a]++
        next[b].add(a)
    }
    prev.indices.filterTo(q) { prev[it] == 0 }
    while (q.isNotEmpty()) {
        val c = q.poll()
        count++
        next[c].forEach {
            if (--prev[it] == 0)
                q.offer(it)
        }
    }
    return count == numCourses
}

/**
 * DFS
 */
fun canFinish_dfs(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val status = Array<Boolean?>(numCourses) { null }
    val prev = Array(numCourses) { ArrayList<Int>() }
    prerequisites.forEach { (a, b) -> prev[a].add(b) }
    fun search(i: Int): Boolean {
        val result = status[i] ?: run {
            status[i] = false
            prev[i].all { search(it) }
        }
        status[i] = result
        return result
    }
    return (0..numCourses).all { search(it) }
}