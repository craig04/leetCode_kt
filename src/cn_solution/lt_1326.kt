package cn_solution

fun minTaps(n: Int, ranges: IntArray): Int {
    val rightmost = IntArray(n + 1)
    ranges.forEachIndexed { i, r ->
        val left = maxOf(0, i - r)
        rightmost[left] = maxOf(rightmost[left], minOf(n, i + r))
    }
    var result = 0
    var cur = 0
    while (true) {
        val right = rightmost[cur]
        result++
        if (right == n)
            break
        cur = (cur..right).maxBy { rightmost[it] }
        if (rightmost[cur] <= right)
            return -1
    }
    return result
}