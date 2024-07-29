package cn_solution

fun nonSpecialCount(l: Int, r: Int): Int {
    val f = BooleanArray(33333)
    var special = 0
    for (i in 2 until f.size) {
        if (f[i])
            continue
        val s = i * i
        when {
            s > r -> break
            s >= l -> special++
        }
        for (j in i * i until f.size step i)
            f[j] = true
    }
    return r - l + 1 - special
}