package cn_solution

fun minMoves(classroom: Array<String>, energy: Int): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = classroom.size
    val m = classroom[0].length
    var x = 0
    var y = 0
    var cnt = 0
    val idx = Array(n) { IntArray(m) }
    for (i in 0 until n)
        for (j in 0 until m)
            when (classroom[i][j]) {
                'L' -> idx[i][j] = cnt++
                'S' -> {
                    x = i
                    y = j
                }
            }
    val status = 1 shl cnt
    val q = ArrayDeque<IntArray>()
    q.add(intArrayOf(x, y, 0, energy, 0))
    val vis = hashSetOf((x * m + y) * status * (energy + 1) + energy)
    while (q.isNotEmpty()) {
        val (i, j, curr, e, s) = q.removeFirst()
        if (curr == status - 1)
            return s
        if (e == 0)
            continue
        for (t in d.indices.step(2)) {
            x = i + d[t]
            y = j + d[t + 1]
            if (x !in 0 until n || y !in 0 until m)
                continue
            var next = curr
            var f = e - 1
            when (classroom[x][y]) {
                'X' -> continue
                'L' -> next = next or (1 shl idx[x][y])
                'R' -> f = energy
            }
            if (vis.add(((x * m + y) * status + next) * (energy + 1) + f))
                q.add(intArrayOf(x, y, next, f, s + 1))
        }
    }
    return -1
}