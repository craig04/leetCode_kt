package cn_solution

fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
    var result = 0
    val n = words.size
    val temp = IntArray(26)
    val count = IntArray(26)
    letters.forEach { count[it - 'a']++ }
    outer@ for (i in 0 until 1.shl(n)) {
        var s = 0
        count.copyInto(temp)
        for (j in 0 until n) {
            if (i.and(1.shl(j)) == 0)
                continue
            for (c in words[j]) {
                if (--temp[c - 'a'] < 0)
                    continue@outer
                s += score[c - 'a']
            }
        }
        result = maxOf(result, s)
    }
    return result
}