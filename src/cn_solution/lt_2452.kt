package cn_solution

fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> {
    return queries.filter { q ->
        dictionary.any { d ->
            q.indices.count { i -> q[i] != d[i] } <= 2
        }
    }
}