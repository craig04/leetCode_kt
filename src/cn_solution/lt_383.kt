package cn_solution

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val count = IntArray(26)
    magazine.toCharArray().forEach { count[it - 'a']++ }
    return ransomNote.toCharArray().all { --count[it - 'a'] >= 0 }
}