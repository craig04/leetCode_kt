package cn_solution

fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
    boxTypes.sortByDescending { it[1] }
    var t = truckSize
    var ans = 0
    for ((box, unit) in boxTypes) {
        val cnt = minOf(t, box)
        ans += cnt * unit
        t -= cnt
        if (t == 0)
            break
    }
    return ans
}