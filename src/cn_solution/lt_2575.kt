package cn_solution

import kotlin.math.sign

fun divisibilityArray(word: String, m: Int): IntArray {
    var remain = 0L
    return IntArray(word.length) {
        remain = (word[it] - '0' + remain * 10) % m
        1 - remain.sign
    }
}