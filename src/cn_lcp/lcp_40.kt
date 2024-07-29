package cn_lcp

fun maxmiumScore(cards: IntArray, cnt: Int): Int {
    cards.sortDescending()
    var ans = 0
    var even = -1
    var odd = -1
    for (i in 0 until cnt) {
        ans += cards[i]
        if (cards[i] % 2 == 0)
            even = cards[i]
        else
            odd = cards[i]
    }
    if (ans % 2 == 0)
        return ans
    val inf = Int.MAX_VALUE
    var sub1 = inf
    var sub2 = inf
    for (i in cnt until cards.size) {
        if (cards[i] % 2 == 0 && odd != -1 && sub1 == inf)
            sub1 = odd - cards[i]
        if (cards[i] % 2 == 1 && even != -1 && sub2 == inf)
            sub2 = even - cards[i]
        if (sub1 != inf && sub2 != inf)
            break
    }
    return if (sub1 == inf && sub2 == inf) 0 else ans - minOf(sub1, sub2)
}