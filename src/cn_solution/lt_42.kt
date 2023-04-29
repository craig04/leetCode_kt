package cn_solution

fun trap(height: IntArray): Int {
    var result = 0
    var i = 1
    var j = height.lastIndex - 1
    var left = height.first()
    var right = height.last()
    while (i <= j) {
        if (left < right) {
            result += maxOf(0, minOf(left, right) - height[i])
            left = maxOf(left, height[i++])
        } else {
            result += maxOf(0, minOf(left, right) - height[j])
            right = maxOf(right, height[j--])
        }
    }
    return result
}