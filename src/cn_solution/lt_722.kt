package cn_solution

fun removeComments(source: Array<String>): List<String> {
    val result = ArrayList<String>()
    val sb = StringBuilder()
    var block = false
    var i = 0
    var j = 0
    val comment = listOf("//", "/*")
    while (i != source.size) {
        val line = source[i]
        if (!block) {
            var t = line.indexOfAny(comment, j)
            if (t == -1)
                t = line.length
            sb.append(line, j, t)
            if (t != line.length && line[t + 1] == '*') {
                block = true
                j = t + 2
            } else {
                j = line.length
            }
        } else {
            val t = line.indexOf("*/", j)
            if (t != -1) {
                block = false
                j = t + 2
            } else {
                j = line.length
            }
        }
        if (j == line.length) {
            i++
            j = 0
            if (!block && sb.isNotEmpty()) {
                result.add(sb.toString())
                sb.clear()
            }
        }
    }
    return result
}