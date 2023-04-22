package cn_solution

fun camelMatch(queries: Array<String>, pattern: String): List<Boolean> {
    return queries.map { str ->
        var j = 0
        for (c in str) {
            if (j == pattern.length) {
                if (c.isUpperCase()) return@map false
            } else if (c == pattern[j]) {
                j++
            } else if (c.isUpperCase()) {
                return@map false
            }
        }
        j == pattern.length
    }
}