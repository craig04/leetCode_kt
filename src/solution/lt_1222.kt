package solution

fun queensAttacktheKing(queens: Array<IntArray>, king: IntArray): List<List<Int>> {

    return mutableListOf<List<Int>>().apply {
        val diff = arrayOf(-1, 0, 1)
        val maps = queens.associateBy { index(it[0], it[1]) }
        for (i in diff) {
            for (j in diff) {
                for (t in 1..8) {
                    val pos = index(king[0] + i * t, king[1] + j * t)
                    val queen = maps[pos]
                    if (queen != null) {
                        add(queen.asList())
                        break
                    }
                }
            }
        }
    }
}

private fun index(x: Int, y: Int) = x.shl(3) + y