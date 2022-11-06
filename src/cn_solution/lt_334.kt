package cn_solution

fun increasingTriplet(nums: IntArray): Boolean {
    var one = Int.MAX_VALUE
    var two = Int.MAX_VALUE
    for (n in nums) {
        when {
            n <= one -> one = n
            n <= two -> two = n
            else -> return true
        }
    }
    return false
}
