package cn_solution

fun beautifulIndices(s: String, a: String, b: String, k: Int): List<Int> {
    fun String.indicesOf(p: String): List<Int> {
        val result = ArrayList<Int>()
        val len = p.length
        var x = 0L
        var y = 0L
        var base = 1L
        val modulo = 1000000007L
        for (i in indices) {
            x = (this[i] - 'a' + x * 31) % modulo
            if (i < len)
                y = (p[i] - 'a' + y * 31) % modulo
            if (i < len - 1)
                base = base * 31 % modulo
            else {
                val start = i - len + 1
                if (x == y)
                    result.add(start)
                x = ((x - base * (s[start] - 'a')) % modulo + modulo) % modulo
            }
        }
        return result
    }
    if (maxOf(a.length, b.length) > s.length)
        return emptyList()
    val pattern = s.indicesOf(b)
    var i = 0
    val size = pattern.size
    return s.indicesOf(a).filter {
        while (i != size && it > pattern[i])
            i++
        i != size && pattern[i] - it <= k || i != 0 && it - pattern[i - 1] <= k
    }
}