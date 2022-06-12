package cn_solution

fun replaceWords(dictionary: List<String>, sentence: String): String {
    class Trie {
        val next = Array<Trie?>(26) { null }
        var leaf = false
    }

    val root = Trie()
    for (pref in dictionary) {
        var temp = root
        for (c in pref) {
            val next = temp.next[c - 'a'] ?: Trie()
            temp.next[c - 'a'] = next
            temp = next
        }
        temp.leaf = true
    }
    fun String.findPrefix(): String {
        val builder = StringBuilder()
        var temp = root
        for (c in this) {
            temp = temp.next[c - 'a'] ?: return this
            builder.append(c)
            if (temp.leaf)
                break
        }
        return builder.toString()
    }
    return sentence.split(' ').joinToString(" ") { it.findPrefix() }
}