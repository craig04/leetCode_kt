package cn_solution

fun findLUSlength(strs: Array<String>): Int {
    val a = strs.asSequence()
        .groupingBy { it }
        .eachCount()
        .entries
        .toTypedArray()
        .apply { sortByDescending { it.key.length } }
    return a.indices.firstOrNull { i ->
        a[i].value == 1 && (0 until i).all { j ->
            val s = a[j].key
            var x = 0
            a[i].key.any { c ->
                while (x != s.length && s[x] != c)
                    x++
                x++ == s.length
            }
        }
    }?.let { a[it].key }?.length ?: -1
}