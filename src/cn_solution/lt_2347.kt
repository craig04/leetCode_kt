package cn_solution

fun bestHand(ranks: IntArray, suits: CharArray): String {
    if (suits.all { it == suits[0] })
        return "Flush"
    val count = IntArray(14)
    ranks.forEach { count[it]++ }
    return when (count.max()!!) {
        1 -> "High Card"
        2 -> "Pair"
        else -> "Three of a Kind"
    }
}