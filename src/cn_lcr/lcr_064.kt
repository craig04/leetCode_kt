package cn_lcr

class MagicDictionary() {

    class Trie {
        val next = Array<Trie?>(26) { null }
        var leaf = false
    }

    private val root = Trie()

    fun buildDict(dictionary: Array<String>) {
        for (s in dictionary) {
            var temp = root
            for (c in s) {
                val next = temp.next[c - 'a'] ?: Trie()
                temp.next[c - 'a'] = next
                temp = next
            }
            temp.leaf = true
        }
    }

    fun search(searchWord: String): Boolean {
        val word = searchWord.toCharArray()
        fun search(root: Trie?, index: Int, used: Boolean): Boolean = when {
            root == null -> false
            index == word.size -> used && root.leaf
            used -> search(root.next[word[index] - 'a'], index + 1, true)
            else -> ('a'..'z').any {
                search(root.next[it - 'a'], index + 1, it != word[index])
            }
        }
        return search(root, 0, false)
    }
}