package cn_solution

fun minNumberOfFrogs(croakOfFrogs: String): Int {
    val count = IntArray(5)
    val indices = IntArray(26)
    "croak".forEachIndexed { i, c -> indices[c - 'a'] = i }
    var result = 0
    croakOfFrogs.forEach { c ->
        val i = indices[c - 'a']
        count[i]++
        if (i == 0) {
            result = maxOf(result, count[i])
            return@forEach
        }
        if (count[i] > count[i - 1])
            return -1
        if (i == 4) {
            count.indices.forEach { count[it]-- }
        }
    }
    return result
}