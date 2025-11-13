package cn_solution

fun findFinalValue(nums: IntArray, original: Int): Int {
    var x = 0
    for (num in nums)
        if (num % original == 0) {
            val y = num / original
            if (y.and(y - 1) == 0)
                x = x or y
        }
    return original * x.inv().takeLowestOneBit()
}