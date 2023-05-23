package cn_solution

fun oddString(words: Array<String>): String {
    var pos = 0
    for (i in 1 until words.size) {
        val cur = words[i]
        if ((1 until cur.length).any {
                val pre = words[i - 1]
                cur[it] - cur[it - 1] != pre[it] - pre[it - 1]
            }) {
            if (pos != 0) {
                return words[pos]
            }
            pos = i
        } else if (pos != 0) {
            return words[pos - 1]
        }
    }
    return words.last()
}