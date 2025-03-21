package cn_solution

fun maximumOr(nums: IntArray, k: Int): Long {
    var fixed = 0
    var allOr = 0
    for (num in nums) {
        fixed = allOr and num or fixed
        allOr = allOr or num
    }
    return nums.maxOf { num -> num.toLong().shl(k).or(allOr.xor(num).or(fixed).toLong()) }
}