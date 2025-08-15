package cn_solution

fun score(cards: Array<String>, x: Char): Int {
    val type1 = IntArray(26)
    val type2 = IntArray(26)
    var type3 = 0
    for (c in cards) {
        when {
            c[0] == x && c[1] == x -> type3++
            c[0] == x -> type1[c[1] - 'a']++
            c[1] == x -> type2[c[0] - 'a']++
        }
    }
    var inner = 0
    var mixed = 0
    fun IntArray.teamUp() {
        val total = sum()
        var pairs = minOf(total - max(), total / 2)
        inner += pairs
        val unary = total - pairs * 2
        pairs = minOf(unary, type3)
        type3 -= pairs
        mixed += pairs
    }
    type1.teamUp()
    type2.teamUp()
    return inner + mixed + minOf(inner, type3 / 2)
}