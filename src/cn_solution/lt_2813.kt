package cn_solution

fun findMaximumElegance(items: Array<IntArray>, k: Int): Long {
    items.sortByDescending { it[0] }
    val q = ArrayDeque<Int>()
    val categories = HashSet<Int>()
    var profit = 0L
    fun calculate() = profit + categories.size.toLong() * categories.size
    for (i in 0 until k) {
        val (p, c) = items[i]
        if (!categories.add(c))
            q.addLast(p)
        profit += p
    }
    var result = calculate()
    var j = k
    while (j < items.size && q.isNotEmpty()) {
        val (p, c) = items[j++]
        if (categories.add(c)) {
            profit += p - q.removeLast()
            result = maxOf(result, calculate())
        }
    }
    return result
}