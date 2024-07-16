package cn_solution

fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
    fun String.stat(): IntArray {
        val ans = IntArray(26)
        forEach { ans[it - 'a']++ }
        return ans
    }

    val all = IntArray(26)
    words2.forEach {
        val cur = it.stat()
        for (i in 0 until 26)
            all[i] = maxOf(all[i], cur[i])
    }
    return words1.filter { s ->
        val cur = s.stat()
        (0 until 26).all { cur[it] >= all[it] }
    }
}