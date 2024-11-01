package cn_lcs

fun halfQuestions(questions: IntArray): Int {
    val cnt = IntArray(1001)
    questions.forEach { cnt[it]++ }
    cnt.sortDescending()
    var sum = questions.size / 2
    return cnt.indexOfFirst {
        sum -= it
        sum <= 0
    } + 1
}