package cn_solution

fun predictPartyVictory(senate: String): String {
    val n = senate.length
    val r = ArrayDeque<Int>()
    val d = ArrayDeque<Int>()
    senate.forEachIndexed { i, c ->
        if (c == 'R')
            r.add(i)
        else
            d.add(i)
    }
    while (true) {
        val x = r.firstOrNull() ?: return "Dire"
        val y = d.firstOrNull() ?: return "Radiant"
        r.removeFirst()
        d.removeFirst()
        if (x < y) {
            r.add(x + n)
        } else {
            d.add(y + n)
        }
    }
}