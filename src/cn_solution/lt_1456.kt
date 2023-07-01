package cn_solution

fun maxVowels(s: String, k: Int): Int {
    val vowel = BooleanArray(26)
    "aeiou".forEach { vowel[it - 'a'] = true }
    var count = 0
    var result = 0
    for (i in s.indices) {
        if (vowel[s[i] - 'a'])
            count++
        if (i < k - 1)
            continue
        result = maxOf(result, count)
        if (vowel[s[i - k + 1] - 'a'])
            count--
    }
    return result
}