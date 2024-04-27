package cn_solution

fun findMaximumElegance(items: Array<IntArray>, k: Int): Long {
    items.sortByDescending { it[0] }
    val q = ArrayList<Int>()
    val count = IntArray(items.size + 1)
    var categories = 0L
    var profit = 0L
    return items.indices.maxOf {
        val (p, c) = items[it]
        if (it < k) {
            if (++count[c] == 1)
                categories++
            else
                q.add(p)
            profit += p
        } else if (q.isNotEmpty() && ++count[c] == 1) {
            categories++
            profit += p - q.removeLast()
        }
        profit + categories * categories
    }
}