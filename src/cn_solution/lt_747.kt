package cn_solution

fun dominantIndex(nums: IntArray): Int {
    var pos = 0
    var x = -1
    var y = -1
    nums.forEachIndexed { i, num ->
        if (num > x) {
            y = x
            x = num
            pos = i
        } else if (num > y) {
            y = num
        }
    }
    return if (x >= 2 * y) pos else -1
}