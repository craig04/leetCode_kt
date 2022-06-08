package cn_solution

fun canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean {
    if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal)
        return false
    val dp = HashMap<Int, Boolean>()
    val desired = maxOf(desiredTotal, 1)
    fun dfs(bits: Int, total: Int): Boolean {
        return dp.getOrPut(bits) {
            total < desired && (1..maxChoosableInteger).any {
                val bit = 1.shl(it - 1)
                bit.and(bits) != 0 && !dfs(bits xor bit, total + it)
            }
        }
    }
    return dfs(1.shl(maxChoosableInteger) - 1, 0)
}