package cn_solution

class TextEditor() {

    private val s1 = CharArray(800000)
    private val s2 = CharArray(800000)
    private var t1 = 0
    private var t2 = 0

    fun addText(text: String) {
        for (c in text)
            s1[t1++] = c
    }

    fun deleteText(k: Int): Int {
        return minOf(t1, k).also { t1 -= it }
    }

    fun cursorLeft(k: Int): String {
        val len = minOf(k, t1)
        repeat(len) { s2[t2++] = s1[--t1] }
        val n = minOf(10, t1)
        return String(s1, t1 - n, n)
    }

    fun cursorRight(k: Int): String {
        val len = minOf(k, t2)
        repeat(len) { s1[t1++] = s2[--t2] }
        val n = minOf(10, t1)
        return String(s1, t1 - n, n)
    }
}