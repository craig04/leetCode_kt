package cn_solution

fun maximumGood(statements: Array<IntArray>): Int {
    val n = statements.size
    var result = 0
    loop@ for (state in 0 until 1.shl(n)) {
        for (a in 0 until n) {
            val x = state shr a and 1
            for (b in 0 until n) {
                if (x == 1 && state shr b and 1 xor statements[a][b] == 1)
                    continue@loop
            }
        }
        result = maxOf(result, state.countOneBits())
    }
    return result
}