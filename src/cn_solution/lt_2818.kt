package cn_solution

import java.util.*

private const val M = 1000000007

fun maximumScore(nums: List<Int>, k: Int): Int {
    val array = nums.toIntArray()
    val factor = IntArray(array.max()!! + 1)
    for (i in 2 until factor.size) {
        if (factor[i] == 0)
            for (j in i until factor.size step i)
                factor[j]++
    }
    val left = IntArray(array.size) { -1 }
    val right = IntArray(array.size) { array.size }
    val s = Stack<Int>()
    array.forEachIndexed { i, n ->
        while (s.isNotEmpty() && factor[array[s.peek()]] < factor[n])
            right[s.pop()] = i
        if (s.isNotEmpty())
            left[i] = s.peek()
        s.add(i)
    }
    val indices = array.indices.sortedByDescending { array[it] }.toIntArray()
    var result = 1L
    var remain = k
    for (i in indices) {
        val pairs = (i - left[i]).toLong() * (right[i] - i)
        val takes = minOf(remain.toLong(), pairs).toInt()
        result = result * power(array[i], takes) % M
        remain -= takes
        if (remain == 0)
            break
    }
    return result.toInt()
}

private fun power(n: Int, m: Int): Long {
    var result = 1L
    var base = n.toLong()
    var remain = m
    while (remain != 0) {
        if (remain and 1 == 1)
            result = result * base % M
        remain /= 2
        base = base * base % M
    }
    return result
}