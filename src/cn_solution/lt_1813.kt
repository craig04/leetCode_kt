package cn_solution

fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
    val w1 = sentence1.split(' ')
    val w2 = sentence2.split(' ')
    val n = w1.size
    val m = w2.size
    val left = (0 until minOf(n, m)).firstOrNull {
        w1[it] != w2[it]
    } ?: return true
    return (1..minOf(n - left, m - left)).all {
        w1[n - it] == w2[m - it]
    }
}