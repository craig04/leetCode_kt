package cn_solution

fun maxDistance(arrays: List<List<Int>>): Int {
    var ans = 0
    var min = 100000
    var max = -100000
    for (a in arrays) {
        ans = maxOf(ans, max - a[0], a.last() - min)
        min = minOf(min, a[0])
        max = maxOf(max, a.last())
    }
    return ans
}