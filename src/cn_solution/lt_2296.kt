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
        val len = minOf(k, t1)
        t1 -= len
        return len
    }

    fun cursorLeft(k: Int): String {
        for (i in 0 until minOf(t1, k))
            s2[t2++] = s1[--t1]
        return export()
    }

    fun cursorRight(k: Int): String {
        for (i in 0 until minOf(t2, k))
            s1[t1++] = s2[--t2]
        return export()
    }

    private fun export(): String {
        val n = minOf(10, t1)
        return String(s1, t1 - n, n)
    }
}