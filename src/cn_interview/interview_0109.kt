package cn_interview

fun isFlipedString(s1: String, s2: String): Boolean {
    return s1.length == s2.length && "$s1$s1".contains(s2)
}