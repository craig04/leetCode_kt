package cn_lcp

fun minJump(jump: IntArray): Int {
    val n = jump.size
    val step = IntArray(n) { -1 }
    val q = ArrayDeque<Int>()
    step[0] = 0
    q.addLast(0)
    var far = 1
    while (q.isNotEmpty()) {
        val i = q.removeFirst()
        val s = step[i]
        val j = i + jump[i]
        if (j >= n)
            return s + 1
        else if (step[j] == -1) {
            step[j] = s + 1
            q.add(j)
        }
        for (k in far until i)
            if (step[k] == -1) {
                step[k] = s + 1
                q.add(k)
            }
        far = i + 1
    }
    return -1
}