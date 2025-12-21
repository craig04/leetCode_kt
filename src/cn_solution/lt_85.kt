package cn_solution

fun maximalRectangle(matrix: Array<CharArray>): Int {
    val m = matrix[0].size
    val heights = IntArray(m)
    val l = IntArray(m + 1)
    val s = IntArray(m + 1)
    s[0] = -1
    fun largestRectangleArea(): Int {
        var ans = 0
        var top = 0
        for (j in 0..m) {
            val h = if (j == m) 0 else heights[j]
            while (top != 0 && heights[s[top]] >= h) {
                val i = s[top--]
                ans = maxOf(ans, (j - l[i] - 1) * heights[i])
            }
            l[j] = s[top]
            s[++top] = j
        }
        return ans
    }
    return matrix.maxOf {
        for (j in 0 until m)
            heights[j] = if (it[j] == '0') 0 else heights[j] + 1
        largestRectangleArea()
    }
}