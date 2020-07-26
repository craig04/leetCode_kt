package solution

fun restoreString(s: String, indices: IntArray): String {
    val chars = CharArray(s.length)
    indices.forEachIndexed { index, i -> chars[i] = s[index] }
    return String(chars)
}