package cn_solution

fun deckRevealedIncreasing(deck: IntArray): IntArray {
    deck.sort()
    val ans = IntArray(deck.size)
    val q = deck.indices.mapTo(ArrayDeque()) { it }
    for (i in deck.indices) {
        ans[q.removeFirst()] = deck[i]
        if (q.isNotEmpty())
            q.addLast(q.removeFirst())
    }
    return ans
}