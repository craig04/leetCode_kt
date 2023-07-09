package cn_solution

fun reverseVowels(s: String): String {
    var l = -1
    var r = s.length
    val temp = CharArray(s.length)
    val vowel = "aeiouAEIOU".toHashSet()
    while (true) {
        while (++l < r && s[l] !in vowel)
            temp[l] = s[l]
        while (--r > l && s[r] !in vowel)
            temp[r] = s[r]
        if (l > r)
            break
        temp[r] = s[l]
        temp[l] = s[r]
    }
    return String(temp)
}