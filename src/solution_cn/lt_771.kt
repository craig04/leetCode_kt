package solution_cn

fun numJewelsInStones(jewels: String, stones: String): Int {
    val set = jewels.toHashSet()
    return stones.count { it in set }
}