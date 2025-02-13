package cn_solution

fun similarPairs(words: Array<String>): Int {
    val map = HashMap<Int, Int>()
    return words.sumOf { word ->
        val bits = word.fold(0) { acc, c -> 1.shl(c - 'a') or acc }
        map.merge(bits, 1, Int::plus)!! - 1
    }
}