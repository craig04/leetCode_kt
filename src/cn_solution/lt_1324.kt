package cn_solution

fun printVertically(s: String): List<String> {
    val t = s.split(' ')
    val len = t.maxOf { it.length }
    return List(len) { j ->
        String(CharArray(t.size) { i ->
            t[i].getOrElse(j) { ' ' }
        }).trimEnd()
    }
}