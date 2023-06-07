package cn_solution

fun canMakePaliQueries(s: String, queries: Array<IntArray>): List<Boolean> {
    val pre = IntArray(s.length + 1)
    s.forEachIndexed { i, c ->
        pre[i + 1] = 1.shl(c - 'a').xor(pre[i])
    }
    return queries.map { (l, r, k) ->
        k * 2 + 1 <= Integer.bitCount(pre[r + 1] xor pre[l])
    }
}