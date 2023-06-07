package cn_solution

fun isCircularSentence(sentence: String): Boolean {
    return sentence.first() == sentence.last() && sentence.indices.all {
        sentence[it] != ' ' || sentence[it - 1] == sentence[it + 1]
    }
}