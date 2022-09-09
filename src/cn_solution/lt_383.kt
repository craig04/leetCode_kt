package cn_solution

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val count = IntArray(26)
    magazine.forEach { count[it - 'a']++ }
    return ransomNote.all { --count[it - 'a'] >= 0 }
}