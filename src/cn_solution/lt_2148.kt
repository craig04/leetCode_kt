package cn_solution

fun countElements(nums: IntArray): Int {
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    var minCount = 0
    var maxCount = 0
    nums.forEach {
        if (it < min) {
            min = it
            minCount = 1
        } else {
            minCount++
        }
        if (it > max) {
            max = it
            maxCount = 1
        } else {
            maxCount++
        }
    }
    return maxOf(0, nums.size - minCount - maxCount)
}