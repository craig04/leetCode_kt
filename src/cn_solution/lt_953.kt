package cn_solution

fun isAlienSorted(words: Array<String>, order: String): Boolean {
    val map = IntArray(26)
    for (i in order.indices) map[order[i] - 'a'] = i
    return (0 until words.lastIndex).all { i ->
        val w1 = words[i]
        val w2 = words[i + 1]
        val len = minOf(w1.length, w2.length)
        val idx = (0 until len).indexOfFirst { w1[it] != w2[it] }
        if (idx == -1) w2.length >= w1.length else map[w1[idx] - 'a'] < map[w2[idx] - 'a']
    }
}