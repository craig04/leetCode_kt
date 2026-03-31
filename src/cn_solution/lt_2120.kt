package cn_solution

fun executeInstructions(n: Int, startPos: IntArray, s: String): IntArray {
    val range = 0 until n
    val m = s.length
    return IntArray(m) { i ->
        var (x, y) = startPos
        var j = i
        while (j < m) {
            when (s[j]) {
                'L' -> y--
                'R' -> y++
                'U' -> x--
                'D' -> x++
            }
            if (x !in range || y !in range)
                break
            j++
        }
        j - i
    }
}