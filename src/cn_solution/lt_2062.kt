package cn_solution

fun countVowelSubstrings(word: String): Int {
    val cnt = HashMap<Char, Int>()
    var s = 0
    var i = 0
    var ans = 0
    for (j in word.indices) {
        if (word[j] !in "aeiou") {
            cnt.clear()
            s = j + 1
            i = s
            continue
        }
        cnt.merge(word[j], 1, Int::plus)
        while (cnt.size == 5)
            cnt.merge(word[i++], -1) { a, b -> if (a + b == 0) null else a + b }
        ans += i - s
    }
    return ans
}