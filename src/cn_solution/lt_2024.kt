package cn_solution

fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
    var f = 0
    var i = 0
    var t = 0
    var j = 0
    return answerKey.indices.maxOf { cur ->
        if (answerKey[cur] == 'F')
            f++
        else
            t++
        while (f > k)
            if (answerKey[i++] == 'F')
                f--
        while (t > k)
            if (answerKey[j++] == 'T')
                t--
        maxOf(cur - i + 1, cur - j + 1)
    }
}