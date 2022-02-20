package cn_solution

fun halvesAreAlike(s: String): Boolean {
    val vowel = "aeiouAEIOU".toHashSet()
    fun countVowel(b: Int, e: Int) = (b until e).count { s[it] in vowel }
    return countVowel(0, s.length / 2) == countVowel(s.length / 2, s.length)
}