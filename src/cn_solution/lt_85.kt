package cn_solution

fun maximalRectangle(matrix: Array<CharArray>): Int {
    val m = if (matrix.isEmpty()) 0 else matrix[0].size
    if (m == 0)
        return 0
    val height = IntArray(m)
    val left = IntArray(m)
    var result = 0
    for (line in matrix) {
        for (j in line.indices) {
            if (line[j] == '0')
                height[j] = 0
            else
                height[j]++
        }
        val stack = ArrayList<Int>()
        height.forEachIndexed { i, h ->
            while (stack.isNotEmpty() && height[stack.last()] >= h) {
                val j = stack.removeLast()
                result = maxOf(result, (i - left[j] - 1) * height[j])
            }
            left[i] = if (stack.isEmpty()) -1 else stack.last()
            stack.add(i)
        }
        while (stack.isNotEmpty()) {
            val j = stack.removeLast()
            result = maxOf(result, (m - left[j] - 1) * height[j])
        }
    }
    return result
}