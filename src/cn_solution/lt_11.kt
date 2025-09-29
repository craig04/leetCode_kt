package cn_solution

fun maxArea(height: IntArray): Int {
    var i = 0
    var j = height.lastIndex
    var result = 0
    while (i != j)
        result = maxOf(result, (j - i) * height[if (height[i] < height[j]) i++ else j--])
    return result
}
