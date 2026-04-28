package cn_solution

fun countWordOccurrences(chunks: Array<String>, queries: Array<String>): IntArray {
    val len = chunks.sumOf { it.length }
    val s = CharArray(len)
    var pos = 0
    for (chunk in chunks) {
        chunk.toCharArray(s, pos)
        pos += chunk.length
    }
    val map = HashMap<String, Int>()
    var i = 0
    while (i < len) {
        if (s[i] == ' ' || s[i] == '-') {
            i++
            continue
        }
        var j = i
        while (j < len && s[j] != ' ' && (s[j] != '-' || j + 1 != len && s[j + 1] in 'a'..'z'))
            j++
        val word = String(s, i, j - i)
        map.merge(word, 1, Int::plus)
        i = j + 1
    }
    return IntArray(queries.size) { map[queries[it]] ?: 0 }
}