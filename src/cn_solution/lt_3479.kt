package cn_solution

private fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
    val n = fruits.size
    val a = IntArray(n * 4)
    fun build(i: Int, l: Int, r: Int) {
        if (l == r) {
            a[i] = baskets[l]
            return
        }
        val mid = (l + r) / 2
        val x = i * 2 + 1
        val y = i * 2 + 2
        build(x, l, mid)
        build(y, mid + 1, r)
        a[i] = maxOf(a[x], a[y])
    }

    fun put(i: Int, l: Int, r: Int, f: Int): Boolean {
        if (a[i] < f)
            return false
        if (l == r) {
            a[i] = 0
            return true
        }
        val mid = (l + r) / 2
        val x = i * 2 + 1
        val y = i * 2 + 2
        put(x, l, mid, f) || put(y, mid + 1, r, f)
        a[i] = maxOf(a[x], a[y])
        return true
    }
    build(0, 0, n - 1)
    return fruits.count { !put(0, 0, n - 1, it) }
}