package cn_solution

fun snakesAndLadders(board: Array<IntArray>): Int {
    val n = board.size
    val m = board[0].size
    val destination = n * m
    val q = ArrayDeque<Int>()
    val step = IntArray(destination + 1) { Int.MAX_VALUE }
    q.addLast(1)
    step[1] = 0
    while (q.isNotEmpty()) {
        val x = q.removeFirst()
        if (x == destination)
            return step[x]
        for (i in 1..6) {
            var y = x + i
            if (y > destination)
                break
            val u = n - 1 - (y - 1) / m
            var v = (y - 1) % m
            if ((n - u) % 2 == 0)
                v = m - 1 - v
            if (board[u][v] != -1)
                y = board[u][v]
            if (step[y] > step[x] + 1) {
                step[y] = step[x] + 1
                q.addLast(y)
            }
        }
    }
    return -1
}