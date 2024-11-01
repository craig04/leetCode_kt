package cn_solution

fun minElement(nums: IntArray): Int {
    return nums.minOf {
        var num = it
        var sum = 0
        while (num != 0) {
            sum += num % 10
            num /= 10
        }
        sum
    }
}