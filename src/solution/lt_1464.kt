package solution

fun maxProduct(nums: IntArray): Int {
    var max1 = Integer.MIN_VALUE
    var max2 = max1
    for (n in nums) {
        if (n > max1) {
            max2 = max1
            max1 = n
        } else if (n > max2) {
            max2 = n
        }
    }
    return (max1 - 1) * (max2 - 1)
}