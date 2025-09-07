package cn_solution

fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
    val vowels = BooleanArray(26)
    "aeiou".forEach { vowels[it - 'a'] = true }
    fun String.wildcard(): String {
        val c = toCharArray()
        for (i in indices) {
            if (vowels[c[i].lowercaseChar() - 'a'])
                c[i] = '*'
            else
                c[i] = c[i].lowercaseChar()
        }
        return String(c)
    }

    val set = HashSet<String>()
    val map1 = HashMap<String, String>()
    val map2 = HashMap<String, String>()
    for (word in wordlist) {
        set.add(word)
        map1.computeIfAbsent(word.lowercase()) { word }
        map2.computeIfAbsent(word.wildcard()) { word }
    }
    return Array(queries.size) {
        val word = queries[it]
        if (word in set) word else map1[word.lowercase()] ?: map2[word.wildcard()] ?: ""
    }
}