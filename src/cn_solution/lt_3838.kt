package cn_solution

fun mapWordWeights(words: Array<String>, weights: IntArray): String {
    return String(CharArray(words.size) { i ->
        'z' - words[i].sumOf { weights[it - 'a'] } % 26
    })
}