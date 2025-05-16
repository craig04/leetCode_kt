package cn_solution

fun canReach(arr: IntArray, start: Int): Boolean {
    val n = arr.size
    val vis = BooleanArray(n)
    val q = ArrayDeque<Int>()
    vis[start] = true
    q.addLast(start)
    while (q.isNotEmpty()) {
        val x = q.removeFirst()
        if (arr[x] == 0)
            return true
        fun jump(step: Int) {
            if (x + step in 0 until n && !vis[x + step]) {
                vis[x + step] = true
                q.addLast(x + step)
            }
        }
        jump(arr[x])
        jump(-arr[x])
    }
    return false
}