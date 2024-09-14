package cn_solution

fun numberOfPoints(nums: List<List<Int>>): Int {
    val diff = IntArray(102)
    for ((b, e) in nums) {
        diff[b]++
        diff[e + 1]--
    }
    var cnt = 0
    return diff.indices.count {
        cnt += diff[it]
        cnt > 0
    }
}