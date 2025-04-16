package cn_solution

fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
    fun solve(target: Int): Int {
        var x = 0
        var y = 0
        for (i in tops.indices) {
            if (tops[i] != target && bottoms[i] != target)
                return Int.MAX_VALUE
            when {
                tops[i] != target -> x++
                bottoms[i] != target -> y++
            }
        }
        return minOf(x, y)
    }

    val ans = minOf(solve(tops[0]), solve(bottoms[0]))
    return if (ans == Int.MAX_VALUE) -1 else ans
}