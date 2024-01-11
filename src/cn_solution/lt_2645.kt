package cn_solution

fun addMinimum(word: String): Int {
    return (1 until word.length).count { word[it - 1] >= word[it] } * 3 + 3 - word.length
}