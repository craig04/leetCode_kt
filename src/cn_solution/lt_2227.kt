package cn_solution

class Encrypter(keys: CharArray, values: Array<String>, dictionary: Array<String>) {

    private val encoder = Array<String?>(26) { null }
    private val decoder = HashMap<String, Int>()

    init {
        keys.forEachIndexed { i, c -> encoder[c - 'a'] = values[i] }
        dictionary.groupingBy { encrypt(it) }.eachCountTo(decoder)
    }

    fun encrypt(word1: String): String {
        val sb = StringBuilder()
        for (c in word1)
            sb.append(encoder[c - 'a'] ?: return "")
        return sb.toString()
    }

    fun decrypt(word2: String): Int {
        return decoder[word2] ?: 0
    }
}