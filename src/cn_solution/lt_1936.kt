package cn_solution

fun addRungs(rungs: IntArray, dist: Int): Int {
    var pre = 0
    var ans = 0
    for (cur in rungs) {
        ans += (cur - pre - 1) / dist
        pre = cur
    }
    return ans
}