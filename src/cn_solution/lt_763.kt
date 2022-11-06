package cn_solution

fun partitionLabels(s: String): List<Int> {
    val right = IntArray(26)
    s.forEachIndexed { i, c -> right[c - 'a'] = i }
    val result = ArrayList<Int>()
    var start = 0
    var end = 0
    s.forEachIndexed { i, c ->
        end = maxOf(end, right[c - 'a'])
        if (i == end) {
            result.add(end - start + 1)
            start = end + 1
        }
    }
    return result
}
