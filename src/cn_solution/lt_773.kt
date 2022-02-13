package cn_solution

import java.util.*
import kotlin.collections.HashSet

fun slidingPuzzle(board: Array<IntArray>): Int {
    val init = buildString {
        for (a in board) {
            a.forEach { append(it) }
        }
    }
    val q = LinkedList<Pair<String, Int>>()
    val s = HashSet<String>()
    val c = init.toCharArray()
    q.offer(Pair(init, 0))
    while (q.isNotEmpty()) {
        val node = q.poll()
        val str = node.first
        val step = node.second
        if (str == "123450") {
            return step
        }
        node.first.toCharArray(c)
        fun swap(i: Int, j: Int) {
            val temp = c[i]
            c[i] = c[j]
            c[j] = temp
        }

        fun swapCheck(i: Int, j: Int) {
            swap(i, j)
            val temp = String(c)
            if (s.add(temp)) {
                q.offer(Pair(temp, step + 1))
            }
            swap(i, j)
        }

        val z = c.indexOf('0')
        val i = z / 3
        val j = z % 3
        if (j != 0) swapCheck(z - 1, z)
        if (j != 2) swapCheck(z + 1, z)
        if (i != 0) swapCheck(z - 3, z)
        if (i != 1) swapCheck(z + 3, z)
    }
    return -1
}