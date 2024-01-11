package cn_solution

fun countWords(words1: Array<String>, words2: Array<String>): Int {
    fun Array<String>.countWords(): Map<String, Int> {
        val map = HashMap<String, Int>()
        for (word in this)
            map[word] = (map[word] ?: 0) + 1
        return map
    }

    val map1 = words1.countWords()
    return words2.countWords().count { (k, v) -> v == 1 && map1[k] == 1 }
}