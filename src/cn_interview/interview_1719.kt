package cn_interview

fun missingTwo(nums: IntArray): IntArray {
    val n = nums.size + 2
    var temp = n.xor(n - 1)
    nums.forEachIndexed { i, num -> temp = temp.xor(num).xor(i + 1) }
    val bit = temp and -temp
    var a = 0
    var b = 0
    fun xor(num: Int) {
        if (num and bit == 0)
            a = a xor num
        else
            b = b xor num
    }
    (1..n).forEach { xor(it) }
    nums.forEach { xor(it) }
    return intArrayOf(a, b)
}