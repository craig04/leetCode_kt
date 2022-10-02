package cn_solution

fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
    var i = 0
    var j = 0
    val result = ArrayList<IntArray>()
    fun check(x: IntArray, y: IntArray) {
        val begin = maxOf(x[0], y[0])
        val end = minOf(x[1], y[1])
        if (begin <= end)
            result.add(intArrayOf(begin, end))
    }
    while (i != firstList.size && j != secondList.size) {
        check(firstList[i], secondList[j])
        if (firstList[i][1] <= secondList[j][1]) {
            i++
        } else {
            j++
        }
    }
    return result.toTypedArray()
}
