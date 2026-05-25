package cn_solution

private fun maximumSaleItems(items: Array<IntArray>, budget: Int): Int {
    val n = items.size
    val cnt = IntArray(n + 1)
    var min = Int.MAX_VALUE
    for ((factor, price) in items) {
        cnt[factor]++
        min = minOf(min, price)
    }
    for (i in 1..n)
        if (cnt[i] != 0) {
            for (j in i + i..n step i)
                cnt[i] += cnt[j]
            cnt[i]--
        }
    val select = items.filterTo(ArrayList()) { (factor, price) ->
        price < 2 * min && cnt[factor] > 0
    }
    select.sortBy { it[1] }
    var ans = 0
    var left = budget
    for ((factor, price) in select) {
        if (left < price)
            break
        val c = minOf(cnt[factor], left / price)
        left -= c * price
        ans += c * 2
    }
    return ans + left / min
}