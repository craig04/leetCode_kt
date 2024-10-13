package cn_solution

fun findAnswer(parent: IntArray, s: String): BooleanArray {
    val n = parent.size
    val g = Array(n) { ArrayList<Int>() }
    for (i in 1 until n)
        g[parent[i]].add(i)
    val enter = IntArray(n)
    val exit = IntArray(n)
    val post = CharArray(n)
    var pos = 0
    fun dfs(x: Int) {
        enter[x] = pos
        g[x].forEach(::dfs)
        post[pos] = s[x]
        exit[x] = pos++
    }
    dfs(0)
    val str = CharArray(n * 2 + 3) { '#' }
    str[0] = '^'
    str[n * 2 + 2] = '$'
    post.forEachIndexed { i, c -> str[i * 2 + 2] = c }
    val len = IntArray(str.size)
    var mid = 0
    var right = 0
    for (i in 2 until str.size - 2) {
        var l = 1
        if (i < right)
            l = minOf(right - i + 1, len[mid * 2 - i])
        while (str[i + l] == str[i - l])
            l++
        len[i] = l
        if (i + l > right) {
            mid = i
            right = i + l - 1
        }
    }
    return BooleanArray(n) { i ->
        val l = enter[i]
        val r = exit[i]
        len[l + r + 2] > r - l
    }
}