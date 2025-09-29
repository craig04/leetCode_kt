package cn_solution

fun removeAnagrams(words: Array<String>): List<String> {
    var len = 0
    var pre = CharArray(0)
    for (i in words.indices) {
        val cur = words[i].toCharArray()
        cur.sort()
        if (!pre.contentEquals(cur)) {
            words[len++] = words[i]
            pre = cur
        }
    }
    return words.asList().subList(0, len)
}