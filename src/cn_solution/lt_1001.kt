package cn_solution

fun gridIllumination(n: Int, lamps: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val light = HashSet<Long>()
    val row = HashMap<Int, Int>()
    val col = HashMap<Int, Int>()
    val pos = HashMap<Int, Int>()
    val neg = HashMap<Int, Int>()
    fun hash(r: Int, c: Int) = r * n.toLong() + c
    fun HashMap<Int, Int>.inc(key: Int) = set(key, (get(key) ?: 0) + 1)
    fun HashMap<Int, Int>.dec(key: Int) {
        val v = get(key) ?: return
        if (v == 1) {
            remove(key)
        } else {
            set(key, v - 1)
        }
    }

    lamps.forEach {
        if (light.add(hash(it[0], it[1]))) {
            row.inc(it[0])
            col.inc(it[1])
            pos.inc(it[0] - it[1])
            neg.inc(it[0] + it[1])
        }
    }
    return IntArray(queries.size) {
        val (r, c) = queries[it]
        val temp = row.containsKey(r)
                || col.containsKey(c)
                || pos.containsKey(r - c)
                || neg.containsKey(r + c)
        for (i in r - 1..r + 1) {
            for (j in c - 1..c + 1) {
                if (i in 0 until n && j in 0 until n && light.remove(hash(i, j))) {
                    row.dec(i)
                    col.dec(j)
                    pos.dec(i - j)
                    neg.dec(i + j)
                }
            }
        }
        if (temp) 1 else 0
    }
}