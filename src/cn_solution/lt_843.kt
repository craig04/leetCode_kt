package cn_solution

fun findSecretWord(words: Array<String>, master: Master) {
    val f = BooleanArray(words.size) { true }
    for (i in words.indices) {
        if (!f[i])
            continue
        val cnt = master.guess(words[i])
        if (cnt == 6)
            break
        f[i] = false
        for (j in words.indices)
            f[j] = f[j] && (0..5).count { words[i] == words[j] } != cnt
    }
}

interface Master {
    fun guess(word: String): Int
}