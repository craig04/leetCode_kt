package cn_solution

fun minDeletion(nums: IntArray): Int {
    var last = -1
    var count = 0
    for (n in nums) {
        if (last == -1) {
            last = n
        } else if (n == last) {
            count++
        } else {
            last = -1
        }
    }
    if (last != -1)
        count++
    return count
}