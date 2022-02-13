package cn_solution

fun longestDiverseString(a: Int, b: Int, c: Int): String {
    class H(val c: Char, var time: Int)

    val t = arrayOf(H('a', a), H('b', b), H('c', c))
    val sb = StringBuilder()
    var next = 0
    fun hasNext(): Boolean {
        t.sortBy { -it.time }
        val len = sb.length
        val forbid = if (len >= 2 && sb[len - 1] == sb[len - 2]) sb[len - 1] else null
        next = t.indexOfFirst { it.time != 0 && it.c != forbid }
        return next != -1
    }
    while (hasNext()) {
        sb.append(t[next].c)
        t[next].time--
    }
    return sb.toString()
}