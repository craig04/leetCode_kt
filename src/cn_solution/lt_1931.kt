package cn_solution

fun colorTheGrid(m: Int, n: Int): Int {
    val modulo = 1000000007
    val total = (0 until m).fold(1) { ans, _ -> ans * 3 }
    val valid = (0 until total).filter {
        var pre = -1
        var tmp = it
        for (i in 0 until m) {
            val rem = tmp % 3
            if (rem == pre)
                return@filter false
            pre = rem
            tmp /= 3
        }
        true
    }.toIntArray()
    val adj = Array(valid.size) { i ->
        valid.indices.filter { j ->
            var a = valid[i]
            var b = valid[j]
            for (k in 0 until m) {
                if (a % 3 == b % 3)
                    return@filter false
                a /= 3
                b /= 3
            }
            true
        }.toIntArray()
    }
    var pre = IntArray(valid.size) { 1 }
    var cur = IntArray(valid.size)
    for (t in 1 until n) {
        cur.fill(0)
        for (i in valid.indices)
            for (j in adj[i])
                cur[i] = (cur[i] + pre[j]) % modulo
        val tmp = pre
        pre = cur
        cur = tmp
    }
    return pre.fold(0) { ans, t -> (ans + t) % modulo }
}