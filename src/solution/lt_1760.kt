package solution

fun minimumSize(nums: IntArray, maxOperations: Int): Int {
    var left = 1
    var right = nums.max()!!
    while (left != right) {
        val m = (right - left).shr(1) + left
        val op = nums.sumBy { (it + m - 1) / m - 1 }
        if (op <= maxOperations) {
            right = m
        } else {
            left = m + 1
        }
    }
    return left
}