package cn_solution

fun evaluate(s: String, knowledge: List<List<String>>): String {
    val map = HashMap<String, String>()
    knowledge.forEach { (k, v) -> map[k] = v }
    var i = 0
    val sb = StringBuilder()
    while (i != s.length) {
        if (s[i] != '(') {
            sb.append(s[i++])
            continue
        }
        var j = i + 1
        while (s[j] != ')')
            j++
        sb.append(map[s.substring(i + 1, j)] ?: "?")
        i = j + 1
    }
    return sb.toString()
}