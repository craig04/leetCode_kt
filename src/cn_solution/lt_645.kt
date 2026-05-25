package cn_solution

fun findErrorNums(nums: IntArray): IntArray {
    val x = nums.indices.fold(0) { res, i -> res xor i + 1 xor nums[i] }
    val lowbit = x.takeLowestOneBit()
    var a = 0
    var b = 0
    for (i in nums.indices) {
        fun test(x: Int) {
            if (x and lowbit == 0)
                a = a xor x
            else
                b = b xor x
        }
        test(i + 1)
        test(nums[i])
    }
    return if (a in nums) intArrayOf(a, b) else intArrayOf(b, a)
}