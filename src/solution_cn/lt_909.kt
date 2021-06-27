package solution_cn

import java.util.*

fun snakesAndLadders(board: Array<IntArray>): Int {
    val q = LinkedList<Pair<Int, Int>>()
    val s = HashSet<Int>()
    val max = board.size * board.size
    q.offer(0 to 0)
    while (q.isNotEmpty()) {
        val node = q.poll()
        val t = node.first
        val step = node.second
        if (t + 1 == max) {
            return step
        }
        for (i in 1..6) {
            val next = t + i
            if (next >= max) {
                continue
            }
            val tr = next / board.size
            val r = board.size - 1 - tr
            val tc = next % board.size
            val c = if (tr and 1 == 0) tc else board.size - 1 - tc
            val p = if (board[r][c] == -1) next else board[r][c] - 1
            if (!s.add(p)) {
                continue
            }
            q.offer(p to step + 1)
        }
    }
    return -1
}