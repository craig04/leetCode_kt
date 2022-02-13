package cn_solution

fun numJewelsInStones(jewels: String, stones: String): Int {
    val set = jewels.toHashSet()
    return stones.count { it in set }
}