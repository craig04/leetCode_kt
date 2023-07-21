package cn_offer

fun reverseLeftWords(s: String, n: Int): String {
    return s.substring(n) + s.subSequence(0, n)
}