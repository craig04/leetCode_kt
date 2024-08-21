package cn_solution

fun maximumBobPoints(numArrows: Int, aliceArrows: IntArray): IntArray {
    var score = 0
    var state = 0
    for (i in 0 until 1.shl(12) - 1) {
        var s = 0
        var cnt = 0
        for (j in 0 until 12)
            if (1 shl j and i != 0) {
                s += j
                cnt += aliceArrows[j] + 1
            }
        if (cnt <= numArrows && s > score) {
            score = s
            state = i
        }
    }
    val ans = IntArray(12) { if (1 shl it and state != 0) aliceArrows[it] + 1 else 0 }
    ans[0] += numArrows - ans.sum()
    return ans
}