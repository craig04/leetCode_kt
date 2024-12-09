package cn_solution

private fun minimumCost(m: Int, n: Int, horizontalCut: IntArray, verticalCut: IntArray): Int {
    horizontalCut.sort()
    verticalCut.sort()
    var h = 1
    var v = 1
    var i = horizontalCut.lastIndex
    var j = verticalCut.lastIndex
    var ans = 0
    while (i >= 0 || j >= 0) {
        if (i < 0 || (j >= 0 && horizontalCut[i] < verticalCut[j])) {
            ans += h * verticalCut[j--]
            v++
        } else {
            ans += v * horizontalCut[i--]
            h++
        }
    }
    return ans
}