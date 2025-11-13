package cn_solution

import kotlin.text.lowercaseChar

fun maskPII(s: String): String {
    val at = s.indexOf('@')
    return if (at == -1) {
        val prefix = arrayOf("", "+*-", "+**-", "+***-")
        val digits = s.filterTo(StringBuilder()) { it.isDigit() }
        "${prefix[digits.length - 10]}***-***-${digits.substring(digits.length - 4)}"
    } else {
        val email = s.lowercase()
        "${email[0]}*****${email[at - 1]}${email.substring(at)}"
    }
}