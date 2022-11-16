package cn_solution

fun numMatchingSubseq(s: String, words: Array<String>): Int {
    var result = 0
    val q = Array(26) { ArrayList<IntArray>() }
    words.forEachIndexed { i, w ->
        q[w[0] - 'a'].add(intArrayOf(i, 0))
    }
    for (c in s) {
        val temp = q[c - 'a']
        q[c - 'a'] = ArrayList()
        for (t in temp) {
            if (words[t[0]].length == ++t[1]) {
                result++
            } else {
                q[words[t[0]][t[1]] - 'a'].add(t)
            }
        }
    }
    return result
}
