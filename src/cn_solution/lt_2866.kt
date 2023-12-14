package cn_solution

fun maximumSumOfHeights(maxHeights: List<Int>): Long {
    val n = maxHeights.size
    val stack = Array(n + 1) { LongArray(3) }
    var top = 0
    stack[0][2] = -1
    val left = LongArray(n) {
        val height = maxHeights[it]
        while (height < stack[top][0])
            top--
        val pre = top++
        stack[top][0] = height.toLong()
        stack[top][1] = stack[pre][1] + height * (it - stack[pre][2])
        stack[top][2] = it.toLong()
        stack[top][1]
    }
    top = 0
    stack[0][2] = n.toLong()
    return maxHeights.indices.reversed().maxOf {
        val height = maxHeights[it]
        while (height < stack[top][0])
            top--
        val pre = top++
        stack[top][0] = height.toLong()
        stack[top][1] = stack[pre][1] + height * (stack[pre][2] - it)
        stack[top][2] = it.toLong()
        left[it] + stack[top][1] - maxHeights[it]
    }
}