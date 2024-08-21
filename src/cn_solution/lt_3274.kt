package cn_solution

fun checkTwoChessboards(coordinate1: String, coordinate2: String): Boolean {
    fun parity(s: String) = ((s[0] - 'a') + (s[1] - '1')) and 1
    return parity(coordinate1) == parity(coordinate2)
}