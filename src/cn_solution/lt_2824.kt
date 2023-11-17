package cn_solution

fun countPairs(nums: List<Int>, target: Int): Int {
    val a = nums.toIntArray()
    a.sort()
    var l = 0
    var r = a.lastIndex
    var result = 0
    while (l < r) {
        if (a[l] + a[r] >= target) {
            r--
        } else {
            result += r - l++
        }
    }
    return result
}