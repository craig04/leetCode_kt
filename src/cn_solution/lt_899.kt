package cn_solution

fun orderlyQueue(s: String, k: Int): String {
    val ca = s.toCharArray()
    if (k != 1) {
        ca.sort()
        return String(ca)
    }
    val size = ca.size
    fun min(a: Int, b: Int): Int {
        for (i in ca.indices) {
            val diff = s[(a + i) % size] - s[(b + i) % size]
            when {
                diff < 0 -> return a
                diff > 0 -> return b
            }
        }
        return a
    }

    val res = s.indices.reduce { a, b -> min(a, b) }
    return buildString {
        ca.indices.forEach { append(ca[(res + it) % size]) }
    }
}