package cn_solution

fun restoreIpAddresses(s: String): List<String> {
    val result = ArrayList<String>()
    val segments = arrayListOf(0)
    fun dfs(n: Int, p: Int) {
        if (n == -1) {
            result.add((1 until segments.size).joinToString(separator = ".") {
                s.substring(segments[it - 1], segments[it])
            })
            return
        }
        val l = maxOf(p + 1, s.length - n * 3)
        val r = minOf(p + 3, s.length - n * 1)
        for (i in l..r) {
            if ((s[p] == '0' && i == p + 1) || (s[p] != '0' && s.substring(p, i).toInt() <= 255)) {
                segments.add(i)
                dfs(n - 1, i)
                segments.removeLast()
            }
        }
    }
    dfs(3, 0)
    return result
}