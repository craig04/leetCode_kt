package cn_solution

fun sortArrayByParity(nums: IntArray): IntArray {
    var l = 0
    var r = nums.size
    val result = IntArray(r)
    for (n in nums)
        result[if (n % 2 == 0) l++ else --r] = n
    return result
}