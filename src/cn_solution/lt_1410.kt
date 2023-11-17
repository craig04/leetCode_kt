package cn_solution

/**
 * 字典树
 */
fun entityParser_trie(text: String): String {
    class Node {
        val next = HashMap<Char, Node>()
        var replace: Char? = null
    }

    val root = Node()
    val origin = arrayOf("&quot;", "&apos;", "&amp;", "&gt;", "&lt;", "&frasl;")
    val replace = arrayOf('\"', '\'', '&', '>', '<', '/')
    origin.indices.forEach {
        var node = root
        for (c in origin[it])
            node = node.next.computeIfAbsent(c) { Node() }
        node.replace = replace[it]
    }

    var node = root
    val sb = StringBuilder()
    var last = 0
    for (i in text.indices) {
        if (text[i] == '&') {
            sb.append(text, last, i)
            last = i
            node = root
        }
        node = node.next[text[i]] ?: root
        if (node == root) {
            sb.append(text, last, i + 1)
            last = i + 1
        } else if (node.replace != null) {
            sb.append(node.replace)
            node = root
            last = i + 1
        }
    }
    sb.append(text, last, text.length)
    return sb.toString()
}

/**
 * 内置正则+字符串替换
 */
fun entityParser_regex(text: String): String {
    val map = hashMapOf(
        "quot" to "\"",
        "apos" to "'",
        "amp" to "&",
        "gt" to ">",
        "lt" to "<",
        "frasl" to "/"
    )
    return text.replace(map.keys.joinToString("|", "&(", ");").toRegex()) { map[it.groupValues[1]] ?: "" }
}