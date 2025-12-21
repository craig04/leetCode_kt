package cn_solution

fun countPairs(words: Array<String>): Long {
    val map = HashMap<Int, Int>()
    return words.sumOf { word ->
        var key = 0
        for (i in 1 until word.length) {
            var dis = word[i] - word[i - 1]
            if (dis < 0)
                dis += 26
            key = key * 26 + dis
        }
        (map.merge(key, 1, Int::plus) ?: 1) - 1L
    }
}