package cn_solution

fun findLongestChain(pairs: Array<IntArray>): Int {
    pairs.sortBy { it[1] }
    var right = Int.MIN_VALUE
    return pairs.count { (l, r) ->
        (l > right).also {
            if (it) right = r
        }
    }
}