package cn_solution

fun minSetSize(arr: IntArray): Int {
    val map = HashMap<Int, Int>()
    arr.forEach { map.merge(it, 1, Int::plus) }
    val cnt = map.values.sortedDescending()
    var sum = 0
    for (i in cnt.indices) {
        sum += cnt[i]
        if (sum >= (arr.size + 1) / 2)
            return i + 1
    }
    return 0
}