package cn_offer

fun singleNumbers(nums: IntArray): IntArray {
    val bit = Integer.lowestOneBit(nums.reduce { a, b -> a xor b })
    var a = 0
    var b = 0
    nums.forEach {
        if (it and bit != 0)
            a = a xor it
        else
            b = b xor it
    }
    return intArrayOf(a, b)
}