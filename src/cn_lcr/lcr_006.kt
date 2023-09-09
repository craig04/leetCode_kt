package cn_lcr

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var l = 0
    var r = numbers.lastIndex
    while (l < r) {
        val sum = numbers[l] + numbers[r]
        when {
            sum > target -> r--
            sum < target -> l++
            else -> return intArrayOf(l, r)
        }
    }
    return IntArray(0)
}