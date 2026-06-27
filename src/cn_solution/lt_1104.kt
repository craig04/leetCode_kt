package cn_solution

fun pathInZigZagTree(label: Int): List<Int> {
    var row = 31 - label.countLeadingZeroBits()
    var idx = label
    if (row % 2 == 1)
        idx = 1.shl(row) * 3 - 1 - idx
    val ans = IntArray(row + 1)
    while (row >= 0) {
        ans[row] = idx
        if (row % 2 == 1)
            ans[row] = 1.shl(row) * 3 - 1 - idx
        row--
        idx /= 2
    }
    return ans.asList()
}