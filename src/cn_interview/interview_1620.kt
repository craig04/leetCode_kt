package cn_interview

fun getValidT9Words(num: String, words: Array<String>): List<String> {
    val map = "22233344455566677778889999"
    return words.filter { word ->
        num.indices.all { num[it] == map[word[it] - 'a'] }
    }
}