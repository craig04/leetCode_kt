package cn_solution

fun rearrangeCharacters(s: String, target: String): Int {
    fun String.counts() = HashMap<Char, Int>().also { map ->
        forEach { map[it] = (map[it] ?: 0) + 1 }
    }

    val store = s.counts()
    return target.counts().entries.fold(Int.MAX_VALUE) { acc, (k, v) ->
        minOf(acc, (store[k] ?: 0) / v)
    }
}