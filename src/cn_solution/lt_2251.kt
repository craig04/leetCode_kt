package cn_solution

import java.util.*

/**
 * 二分查找 + 在线查询
 */
fun fullBloomFlowers_binarySearch(flowers: Array<IntArray>, people: IntArray): IntArray {
    val start = IntArray(flowers.size) { flowers[it][0] }
    val end = IntArray(flowers.size) { flowers[it][1] }
    start.sort()
    end.sort()
    fun IntArray.search(x: Int): Int {
        var l = 0
        var r = size
        while (l != r) {
            val m = (l + r) shr 1
            if (this[m] > x)
                r = m
            else
                l = m + 1
        }
        return r
    }
    return IntArray(people.size) {
        start.search(people[it]) - end.search(people[it] - 1)
    }
}

/**
 * 差分数组 + 离线查询
 */
fun fullBloomFlowers_differentialArray(flowers: Array<IntArray>, people: IntArray): IntArray {
    val map = HashMap<Int, Int>()
    flowers.forEach { (s, e) ->
        map[s] = (map[s] ?: 0) + 1
        map[e + 1] = (map[e + 1] ?: 0) - 1
    }
    val result = IntArray(people.size)
    val diff = map.entries.sortedBy { it.key }
    val indices = people.indices.sortedBy { people[it] }
    var i = 0
    var sum = 0
    for (idx in indices) {
        val time = people[idx]
        while (i != diff.size && diff[i].key <= time)
            sum += diff[i++].value
        result[idx] = sum
    }
    return result
}