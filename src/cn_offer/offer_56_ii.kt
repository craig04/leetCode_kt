package cn_offer

fun singleNumber(nums: IntArray): Int {
    var a = 0
    var b = 0
    for (n in nums) {
        a = n and b.inv() xor a
        b = n and a.inv() xor b
    }
    return a
}