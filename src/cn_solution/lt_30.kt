package cn_solution

fun findSubstring(s: String, words: Array<String>): List<Int> {
    val result = ArrayList<Int>()
    val m = words[0].length
    val threshold = (words.size - 1) * m
    val init = HashMap<String, Int>()
    words.forEach { init[it] = (init[it] ?: 0) + 1 }
    for (start in words[0].indices) {
        val diff = HashMap(init)
        for (i in start..s.length - m step m) {
            var str = s.substring(i, i + m)
            when (val cnt = diff[str] ?: 0) {
                1 -> diff.remove(str)
                else -> diff[str] = cnt - 1
            }
            if (i < start + threshold)
                continue
            if (diff.isEmpty())
                result.add(i - threshold)
            str = s.substring(i - threshold, i - threshold + m)
            when (val cnt = diff[str] ?: 0) {
                -1 -> diff.remove(str)
                else -> diff[str] = cnt + 1
            }
        }
    }
    return result
}