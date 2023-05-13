package cn_interview

fun computeSimilarities(docs: Array<IntArray>): List<String> {
    val n = docs.size
    val intersection = Array(n) { IntArray(n) }
    val map = HashMap<Int, ArrayList<Int>>()
    docs.forEachIndexed { i, doc ->
        for (d in doc) {
            val list = map.computeIfAbsent(d) { ArrayList() }
            for (s in list)
                intersection[s][i]++
            list.add(i)
        }
    }
    val result = ArrayList<String>()
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val s = intersection[i][j]
            if (s != 0) {
                val r = s * 1.0 / (docs[i].size + docs[j].size - s)
                result.add(String.format("%d,%d: %.4f", i, j, r))
            }
        }
    }
    return result
}