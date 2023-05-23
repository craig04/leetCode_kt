package cn_interview

class WordsFrequency(book: Array<String>) {

    private val frequency = HashMap<String, Int>().also {
        book.forEach { w -> it[w] = (it[w] ?: 0) + 1 }
    }

    fun get(word: String): Int {
        return frequency[word] ?: 0
    }
}