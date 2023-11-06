package cn_solution

fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
    var last = 1
    var length = 0
    var result = 0
    for (n in nums) {
        if (n > threshold) {
            length = 0
            last = 1
        } else if (n % 2 == last) {
            length = last xor 1
        } else {
            last = last xor 1
            result = maxOf(result, ++length)
        }
    }
    return result
}