package cn_solution

fun maximumXOR(nums: IntArray): Int {
    return nums.reduce(Int::or)
}