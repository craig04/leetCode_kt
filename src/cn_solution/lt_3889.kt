package cn_solution

import kotlin.math.abs

fun mirrorFrequency(s: String): Int {
    val letters = IntArray(26)
    val numbers = IntArray(10)
    for (c in s) {
        if (c.isLetter()) {
            letters[c - 'a']++
            letters['z' - c]--
        } else {
            numbers[c - '0']++
            numbers['9' - c]--
        }
    }
    return (letters.sumOf { abs(it) } + numbers.sumOf { abs(it) }) / 2
}