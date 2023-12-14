package cn_solution

fun longestObstacleCourseAtEachPosition(obstacles: IntArray): IntArray {
    val stack = IntArray(obstacles.size + 1) { 0 }
    var top = 1
    return IntArray(obstacles.size) {
        var l = 0
        var r = top
        while (l != r) {
            val m = (l + r) shr 1
            if (stack[m] <= obstacles[it])
                l = m + 1
            else
                r = m
        }
        if (l == top)
            stack[top++] = obstacles[it]
        else
            stack[l] = minOf(stack[l], obstacles[it])
        l
    }
}