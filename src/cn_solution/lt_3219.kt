package cn_solution

fun minimumCost(m: Int, n: Int, horizontalCut: IntArray, verticalCut: IntArray): Long {
    horizontalCut.sort()
    verticalCut.sort()
    var i = horizontalCut.lastIndex
    var j = verticalCut.lastIndex
    var hor = 1L
    var ver = 1L
    var ans = 0L
    while (i >= 0 || j >= 0) {
        if (j < 0 || (i >= 0 && horizontalCut[i] > verticalCut[j])) {
            ans += ver * horizontalCut[i--]
            hor++
        } else {
            ans += hor * verticalCut[j--]
            ver++
        }
    }
    return ans
}