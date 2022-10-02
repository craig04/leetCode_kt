package cn_solution

fun maxArea(height: IntArray): Int {
    var i = 0
    var j = height.lastIndex
    var result = 0
    while (i != j) {
        result = maxOf(
            result, if (height[i] < height[j])
                (j - i).times(height[i++])
            else
                (j - i).times(height[j--])
        )
    }
    return result
}
