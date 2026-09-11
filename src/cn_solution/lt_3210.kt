package cn_solution

fun getEncryptedString(s: String, k: Int): String {
    val n = s.length
    return String(CharArray(n) { s[(it + k) % n] })
}