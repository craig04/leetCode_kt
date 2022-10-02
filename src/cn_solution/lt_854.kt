package cn_solution

fun kSimilarity(s1: String, s2: String): Int {
    fun CharArray.swap(i: Int, j: Int) {
        val tmp = this[i]
        this[i] = this[j]
        this[j] = tmp
    }

    val q = ArrayDeque<String>()
    val steps = hashMapOf(s1 to 0)
    q.add(s1)
    while (q.isNotEmpty()) {
        val s = q.removeFirst()
        val step = steps[s] ?: 0
        val i = s.indices.firstOrNull { s[it] != s2[it] } ?: return step
        val ca = CharArray(s.length) { s[it] }
        for (j in i + 1 until s.length) {
            if (s[j] != s2[i])
                continue
            ca.swap(i, j)
            val next = String(ca)
            if (steps.putIfAbsent(next, step + 1) == null) {
                q.add(next)
            }
            ca.swap(i, j)
        }
    }
    return -1
}
