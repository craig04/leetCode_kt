package cn_solution

fun numDifferentIntegers(word: String): Int {
    val set = HashSet<String>()
    var start = 0
    for (i in word.indices) {
        if (word[i] in 'a'..'z') {
            start = i + 1
        } else if (i == word.lastIndex || word[i + 1] in 'a'..'z') {
            while (start != i && word[start] == '0')
                start++
            set += word.substring(start, i + 1)
        }
    }
    return set.size
}