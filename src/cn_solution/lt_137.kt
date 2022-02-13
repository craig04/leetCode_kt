package cn_solution

private fun singleNumber(nums: IntArray): Int {
    var a = 0
    var b = 0
    for (n in nums) {
        b = b xor n and a.inv()
        a = a xor n and b.inv()
    }
    return b
}