package cn_solution

fun minimumCardPickup(cards: IntArray): Int {
    val map = IntArray(1000001) { -1 }
    var ans = Int.MAX_VALUE
    cards.forEachIndexed { i, card ->
        if (map[card] != -1)
            ans = minOf(ans, i - map[card] + 1)
        map[card] = i
    }
    return if (ans == Int.MAX_VALUE) -1 else ans
}