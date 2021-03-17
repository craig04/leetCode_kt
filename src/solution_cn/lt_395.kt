package solution_cn

import java.util.regex.Pattern

fun longestSubstring(s: String, k: Int): Int {
    if (s.isEmpty()) {
        return 0
    }
    val map = HashMap<Char, Int>()
    for (c in s) {
        map[c] = (map[c] ?: 0) + 1
    }
    val delimiters = map.filter { it.value < k }
    if (delimiters.isEmpty()) {
        return s.length
    }
    val regex = buildString {
        append('[')
        delimiters.forEach { append(it.key) }
        append(']')
    }
    return s.split(Pattern.compile(regex)).map {
        longestSubstring(it, k)
    }.maxOrNull() ?: 0
}