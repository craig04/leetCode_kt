package cn_solution

fun largestRectangleArea(heights: IntArray): Int {
    val n = heights.size
    val l = IntArray(n + 1)
    val s = arrayListOf(-1)
    var ans = 0
    for (j in 0..n) {
        val h = if (j == n) 0 else heights[j]
        while (s.size > 1 && heights[s.last()] >= h) {
            val i = s.removeLast()
            ans = maxOf(ans, (j - l[i] - 1) * heights[i])
        }
        l[j] = s.last()
        s.add(j)
    }
    return ans
}