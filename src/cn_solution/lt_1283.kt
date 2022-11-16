package cn_solution

fun smallestDivisor(nums: IntArray, threshold: Int): Int {
    fun smaller(divisor: Int): Boolean {
        return nums.sumBy { (it + divisor - 1) / divisor } <= threshold
    }

    var left = 1
    var right = nums.max()!!
    while (left != right) {
        val mid = (left + right) shr 1
        when (smaller(mid)) {
            true -> right = mid
            else -> left = mid + 1
        }
    }
    return left
}
